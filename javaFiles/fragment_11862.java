public abstract class Human {

    protected String name;

    protected int age;

    public static abstract class HumanBuilder<H extends Human, 
                                              T extends HumanBuilder<H, T>> {
        protected String name;

        protected int age;

        @SuppressWarnings("unchecked")
        public T name(String name) {
            this.name = name;
            return (T) this;
        }

        @SuppressWarnings("unchecked")
        public T age(int age) {
            this.age = age;
            return (T) this;
        }

        protected void fill(H human) {
            human.name = this.name;
            human.age = this.age;
        }

        protected abstract H create();

        public final H build() {
            H human = this.create();
            this.fill(human);
            return human;
        }
    }
}