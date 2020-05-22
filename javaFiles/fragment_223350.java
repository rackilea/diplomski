import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Person {

    private final String name;
    private final String state;
    private final BigDecimal salary;

    public Person(String name, String state, BigDecimal salary) {
        this.name = name;
        this.state = state;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        Person p1 = new Person("John", "NY", new BigDecimal("2000"));
        Person p2 = new Person("Jack", "NY", new BigDecimal("3000"));
        Person p3 = new Person("Jane", "GA", new BigDecimal("1500"));
        Person p4 = new Person("Jackie", "GA", new BigDecimal("2500"));

        Map<String, BigDecimal> result =
            Stream.of(p1, p2, p3, p4).collect(
                Collectors.groupingBy(Person::getState,
                                      Collectors.mapping(Person::getSalary,
                                                         new AveragingCollector())));
        System.out.println("result = " + result);

    }

    private static class AveragingCollector implements Collector<BigDecimal, IntermediateResult, BigDecimal> {
        @Override
        public Supplier<IntermediateResult> supplier() {
            return IntermediateResult::new;
        }

        @Override
        public BiConsumer<IntermediateResult, BigDecimal> accumulator() {
            return IntermediateResult::add;
        }

        @Override
        public BinaryOperator<IntermediateResult> combiner() {
            return IntermediateResult::combine;
        }

        @Override
        public Function<IntermediateResult, BigDecimal> finisher() {
            return IntermediateResult::finish
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Collections.emptySet();
        }
    }

    private static class IntermediateResult {
        private int count = 0;
        private BigDecimal sum = BigDecimal.ZERO;

        IntermediateResult() {
        }

        void add(BigDecimal value) {
            this.sum = this.sum.add(value);
            this.count++;
        }

        IntermediateResult combine(IntermediateResult r) {
            this.sum = this.sum.add(r.sum);
            this.count += r.count;
            return this;
        }

        BigDecimal finish() {
            return sum.divide(BigDecimal.valueOf(count), 2, BigDecimal.ROUND_HALF_UP);
        }
    }
}