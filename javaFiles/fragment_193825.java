public enum Enum {
        INSTANCE1,
        INSTANCE2("name");

        private String name;

        private Enum () {
            name = "";
        }

        private Enum (String name) {
            this.name = name;
        }
    }


    public final class Class {
        public static final Class INSTANCE1 = new Class();
        public static final Class INSTANCE2 = new Class("name");

        private String name;

        private Class () {
            name = "";
        }

        private Class (String name) {
            this.name = name;
        }
    }