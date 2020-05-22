class Utility<K> {   
    public K[] array(K... ks) {
        return ks;
    }

    public K[] otherMethod(K k1, K k2) {
        return array(k1, k2);
    }
}    

class Test {
    public static void main(String[] args) throws Exception {
        Utility<String> util = new Utility<String>();
        // Bang!
        String[] array = util.otherMethod("foo", "bar");
    }
}