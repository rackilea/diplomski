public static void main(String[] args) throws Exception {

    String value="(-21.2873623,160.2323,1)";
    String line = value.toString();
    String[] longLatArray = line.split(",");
    double lat = Double.parseDouble((longLatArray[0]).substring(1));
    System.out.println(lat);
}