class MyClass {

    // This changes depending on your entry point, e.g. it's different on Tomcat/JBoss
    public static void main(String[] args) {
        // get array of maps using JSON parser ...

        for(Map<String,Object> map:myMapArray) {
            // change value
            map.put('age', ((Map<String,Object>) map.get('age')).get('years'));
        }

        // do other stuff...
    }
}