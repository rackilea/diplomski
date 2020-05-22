public class Test {
    public static void main(String[] args) throws InterruptedException {
            String typeName = "Edm.Double";
            String namePreparedForEncoding = typeName.replace('.', '_');
            Type type = Type.valueOf(namePreparedForEncoding);
            System.out.println(type);

            String memberValue = "42.99";
            SwitchInputType<?> value = type.makeType(memberValue);
            System.out.println(value);

            String typeName1 = "Edm.Int32";
            String namePreparedForEncoding1 = typeName1.replace('.', '_');
            Type type1 = Type.valueOf(namePreparedForEncoding1);
            System.out.println(type1);

            String memberValue1 = "42";
            SwitchInputType<?> value1 = type1.makeType(memberValue1);
            System.out.println(value1);
    }

    enum Type {
        Edm_Boolean {
            SwitchInputType makeType(String memberValue) {
                return new SwitchInputType<Boolean>(new Boolean(memberValue));
            }
        },
        Edm_Double {
            SwitchInputType makeType(String memberValue) {
                return new SwitchInputType<Double>(new Double(memberValue));
            }
        },
        Edm_Int32 {
            SwitchInputType makeType(String memberValue) {
                return new SwitchInputType<Integer>(new Integer(memberValue));
            }
        };

        // All must do this.
        abstract SwitchInputType makeType(String memberValue);
    }

    static class SwitchInputType<T> {
        private Object o;

        public SwitchInputType(Object o) {
            this.o = o;
        }

        @Override
        public String toString() {
            return "SwitchInputType: " + o.toString();
        }
    }
}