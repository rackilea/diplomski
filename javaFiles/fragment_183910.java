public static void main(String[] args) {
    Function<Integer> original = new Function<Integer>() {
        public Integer operate(Map<String,Integer> values) {
            // these will throw exceptions if they don't exist, which is desired
            // granted it's NullPointerException instead of IllegalStateException, but close enough for this example
            int age = values.get("age").intValue();
            int height = values.get("height").intValue();
            int fights = values.get("fights").intValue();
            return (age+height)*fights;
        }
    };
    Map<String,Integer> map = new Map<String,Integer>();
    map.put("age",10);
    map.put("height",100);
    map.put("fights",25);
    Calculation<Integer> calc = new Calculation<Integer>(map,original);

    // later someone can replace either the values in the backing map
    // or replace the function altogether to get a new function
}