public String getKursbetyg() {
    List<String> list = Arrays.asList(uppgiftsbetyg);
    if(list.contains("u")) {
        return "u";
    }
    int index=list.indexOf("vg");
    if(index>=0 && list.subList(index+1, list.size()).contains("vg")) {
        return "vg";
    }
    return "g";
}