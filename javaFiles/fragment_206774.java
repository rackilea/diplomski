public static void main(String[] args) {
    String data;
    try {
        data = IOUtils.toString(new URL("https://celestrak.com/NORAD/elements/resource.txt"));
        for (String line : data.split("\n")) {
            System.out.println(line);
        }
    } catch (IOException e1) {
        e1.printStackTrace();
    }
}