String response = "I:BARCO@noiclt22815||K:CMS||O:REgetPerspectiveList||A0:googleP||A1:yahooP||A2:gmail||A3:test||A4:hello||A16:CCTV Barco||A17:CCTV: Corridor CC||A18:CCTV: DR Andy Warhol||A19:CCTV: DR Gaudi (Analog)||A20:CCTV: DR Miro||A21:CCTV: Entrance CC||A22:CCTV: Gaudi Demo Room Megapixel||";
String[] metaParts = response.split("\\|\\|");

for (int i=0; i < metaParts.length; ++i) {
    String property = metaParts[i].replaceAll("(.*):(.*)", "$1");
    String attribute = metaParts[i].replaceAll("(.*):(.*)", "$2");
    System.out.println(property + ":" + attribute);
}