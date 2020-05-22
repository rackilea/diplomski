import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import java.util.stream.Collector;

public class Temp5 {

  public static void main(String[] args) {
    // List<Character> strs = List.of("abc");
    List<List<Character>> lettersAndNumbers = Stream.of('5', 't', 'o', '9', 'p', '1', 'h')
        .collect(teeing(
                Collectors.filtering(Character::isLetter, Collectors.toList()),
                Collectors.filtering(not(Character::isLetter), Collectors.toList()),
                List::of    
        ));
    }

    public static <T, R1, R2, R>
    Collector<T, ?, R> teeing(Collector<? super T, ?, R1> downstream1,
                              Collector<? super T, ?, R2> downstream2,
                              BiFunction<? super R1, ? super R2, R> merger) {
        return teeing0(downstream1, downstream2, merger);
    }

    private static <T, A1, A2, R1, R2, R>
    Collector<T, ?, R> teeing0(Collector<? super T, A1, R1> downstream1,
                               Collector<? super T, A2, R2> downstream2,
                               BiFunction<? super R1, ? super R2, R> merger) {
        Objects.requireNonNull(downstream1, "downstream1");
        Objects.requireNonNull(downstream2, "downstream2");
        Objects.requireNonNull(merger, "merger");

        Supplier<A1> c1Supplier = Objects.requireNonNull(downstream1.supplier(), "downstream1 supplier");
        Supplier<A2> c2Supplier = Objects.requireNonNull(downstream2.supplier(), "downstream2 supplier");
        BiConsumer<A1, ? super T> c1Accumulator =
                Objects.requireNonNull(downstream1.accumulator(), "downstream1 accumulator");
        BiConsumer<A2, ? super T> c2Accumulator =
                Objects.requireNonNull(downstream2.accumulator(), "downstream2 accumulator");
        BinaryOperator<A1> c1Combiner = Objects.requireNonNull(downstream1.combiner(), "downstream1 combiner");
        BinaryOperator<A2> c2Combiner = Objects.requireNonNull(downstream2.combiner(), "downstream2 combiner");
        Function<A1, R1> c1Finisher = Objects.requireNonNull(downstream1.finisher(), "downstream1 finisher");
        Function<A2, R2> c2Finisher = Objects.requireNonNull(downstream2.finisher(), "downstream2 finisher");

        Collector.Characteristics[] characteristics;
        Set<Collector.Characteristics> c1Characteristics = downstream1.characteristics();
        Set<Collector.Characteristics> c2Characteristics = downstream2.characteristics();
        EnumSet<Collector.Characteristics> c = EnumSet.noneOf(Collector.Characteristics.class);
        c.addAll(c1Characteristics);
        c.retainAll(c2Characteristics);
        c.remove(Collector.Characteristics.IDENTITY_FINISH);
        characteristics = c.toArray(new Collector.Characteristics[0]);

        class PairBox {
            A1 left = c1Supplier.get();
            A2 right = c2Supplier.get();
            void add(T t) {
                c1Accumulator.accept(left, t);
                c2Accumulator.accept(right, t);
            }
            PairBox combine(PairBox other) {
                left = c1Combiner.apply(left, other.left);
                right = c2Combiner.apply(right, other.right);
                return this;
            }
            R get() {
                R1 r1 = c1Finisher.apply(left);
                R2 r2 = c2Finisher.apply(right);
                return merger.apply(r1, r2);
            }
        }
        return Collector.of(PairBox::new, PairBox::add, PairBox::combine, PairBox::get, characteristics);
    }
    @SuppressWarnings("unchecked")
    static <T> Predicate<T> not(Predicate<? super T> target) {
        Objects.requireNonNull(target);
        return (Predicate<T>)target.negate();
    }
}