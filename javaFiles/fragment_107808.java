public class OuterClass extends ClassToExtend {

    public enum Enum { value1, value2 };

    public class InnerClass extends AnotherClassToExtend {

        public void aMethod(Enum position) {
            switch (position) {
                case value1:
                    //Do something
                case value2:
                    //Do Something else
            }
        }
    }
}