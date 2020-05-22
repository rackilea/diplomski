try {
    InputStreamReader in = new InputStreamReader(System.in);
    BufferedReader reader = new BufferedReader(in);

    System.out.println("Enter Class Name: ");
    String whatClass = reader.readLine();

    Class exampleClass = Class.forName(whatClass);
    Object ob = exampleClass.newInstance();

} catch (ClassNotFoundException e) {
    e.printStackTrace();

} catch (Exception e) {
    e.printStackTrace();
}