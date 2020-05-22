public class User
        extends RealmObject {
    @PrimaryKey
    private long id;
    private String name;

    public static enum Fields { //this is the "metamodel"
        ID("id"),
        NAME("name");

        private String fieldName;

        Fields(String fieldName) {
            this.fieldName = fieldName;
        }

        public String getField() {
            return fieldName;
        }

        @Override
        public String toString() {
            return getField();
        }
    }
}