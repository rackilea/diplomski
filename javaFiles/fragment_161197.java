public static void main(String args[]) throws Exception {
    String[] stringArray = new String[]{"One,", "Two", "Three"};
    String serialized = serializeArray(stringArray);
    String[] deserialized = deserializeArray(serialized);
    System.out.println(Arrays.toString(stringArray));
    System.out.println(serialized);
    System.out.println(Arrays.toString(deserialized));
}