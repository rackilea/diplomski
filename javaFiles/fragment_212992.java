public MyClass {
    private Map<String, Integer> map1;
    private Map<String, String>  map2;
    // pretend you don't want people to be able to swap out the map after construction so you protect the setter here.
    protected void setMap1( Map<String, Integer> map1 ) {
        this.map1 = map1;
    }
    protected void setMap1( Map<String, String> map2 ) {
        this.map2 = map2;
    }
    // getters for the maps and other properties
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private Map<String, Integer> map1;
        private Map<String, String> map2;
        public Builder withMap1( Map<String, Integer> map ) {
            map1 = map;
            return this;
        }
        public Builder withMap2( Map<String, String> map ) {
            map2 = map;
            return this;
        }
        public MyClass build() {
            MyClass c = new MyClass();
            // possibly conditional code that inspects the maps for specific values or validity
            c.setMap1( map1 );
            c.setMap2( map2 );
            // initialization of other fields
            return c;
        }
    }

    public static void main( String[] args ) {
        // sample usage
        MyClass instance1 = MyClass.builder().withMap1(myMap1).build();
        MyClass instance2 = MyClass.builder().withMap2(myMap2).build();
        MyClass instance3 = MyClass.builder().withMap1(myMap1).withMap2(myMap2).build();
    }
}