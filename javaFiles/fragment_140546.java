abstract class Bee {
    static final Bee DEAD_BEE = new Bee() {
        @Override
        Bee anotherDay() {
            return this;
        }
    };
}

class SomeBee extends Bee {
    @Override
    Bee anotherDay() {
        if (/* is dead */) {
            return Bee.DEAD_BEE;
        } else {
            ...

class Hive {
    void anotherDay() {
        ...

        for (/*    */) {

            Bee next = bee.anotherDay();
            if (next == Bee.DEAD_BEE) {
                /* it's dead */
            } else {
                ...