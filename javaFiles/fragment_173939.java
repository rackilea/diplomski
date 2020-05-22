private static String getName(BufferedReader input) {
    System.out.println("Do You Remember What Your Name Is?");
    try {
        String name = input.readLine();
        return name;
    } catch (IOException ioe) {
        ioe.printStackTrace();
        return "";
    }
}