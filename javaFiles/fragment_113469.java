import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Try;

interface Lol {
    default Try<Seq<? extends Number>> lol() {
        return Try.of(List::empty);
    }
}

class LolImpl implements Lol {
    @Override
    public Try<Seq<? extends Number>> lol() {
        return Try
                .<Seq<? extends Number>>of(() -> List.of(1, 2, 3))
                .onFailure(t -> System.out.println(t.getMessage()));

    }

    public static void main(String[] args) {
        System.out.println(new LolImpl().lol());
    }
}