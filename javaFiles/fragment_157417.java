public static void main(String[] args) {
    class MappedValue {
        public MappedValue(String id, boolean touched) {
            identifier = id;
            this.touched = touched;
        }
        private String identifier;
        private boolean touched;
        @Override
        public String toString() {
            return "MappedValue [identifier=" + identifier + ", touched=" + touched + "]";
        }
    }

    MultiMap multiMap = new MultiValueMap();
    MappedValue mv = new MappedValue("1", false);
    MappedValue mv2 = new MappedValue("2", true);
    multiMap.put("key1", mv);
    multiMap.put("key1", mv2);
    //Below is the problem as both values in the get removed instead of 1(mv).
    multiMap.remove("key1", mv);
    System.out.println(multiMap.get("key1"));
}