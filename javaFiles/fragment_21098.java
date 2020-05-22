import java.beans.ConstructorProperties;

public class SuperClass {
    public int foo;

    @ConstructorProperties({"foo"})
    protected SuperClass(int foo) {
        this.foo = foo;
    }

    public int getFoo() {
        return this.foo;
    }

    public static class SubClass extends SuperClass {
        private int bar;

        private SubClass(int foo, int bar) {
            super(foo);
            this.bar = bar;
        }

        public static SuperClass.SubClass.SubClassBuilder builder() {
            return new SuperClass.SubClass.SubClassBuilder();
        }

        public SuperClass.SubClass.SubClassBuilder toBuilder() {
            return (new SuperClass.SubClass.SubClassBuilder()).foo(this.foo).bar(this.bar);
        }

        public int getBar() {
            return this.bar;
        }

        public static class SubClassBuilder {
            private int foo;
            private int bar;

            SubClassBuilder() {
            }

            public SuperClass.SubClass.SubClassBuilder foo(int foo) {
                this.foo = foo;
                return this;
            }

            public SuperClass.SubClass.SubClassBuilder bar(int bar) {
                this.bar = bar;
                return this;
            }

            public SuperClass.SubClass build() {
                return new SuperClass.SubClass(this.foo, this.bar);
            }

            public String toString() {
                return "SuperClass.SubClass.SubClassBuilder(foo=" + this.foo + ", bar=" + this.bar + ")";
            }
        }
    }
}