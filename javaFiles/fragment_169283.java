try {
    InputStream is = new Object(){}.getClass().getResourceAsStream("/myfile.txt");
} catch (Exception e) {
    System.err.println("Something went wrong");
    e.printStackTrace();
}