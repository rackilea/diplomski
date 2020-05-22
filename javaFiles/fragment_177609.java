class test {
    public static void main(String[] args) throws Exception {
       System.loadLibrary("_example");
       byte[] data = example.getData();
       System.out.println(new String(data));
    }
}