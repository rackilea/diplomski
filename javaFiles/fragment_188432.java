public static void main(String[] args) throws NoSuchMethodException, SecurityException {

    ArrayList<Integer> i = new ArrayList<>();
    i.getClass().getDeclaredMethod("add", new Class[] { Object.class } );  // Works
    i.getClass().getDeclaredMethod("add", new Class[] { Integer.class } ); // Fails
}