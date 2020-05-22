public String getKursbetyg() {
    List<String> list = Arrays.asList(uppgiftsbetyg);
    if(list.contains("u")) {
        return "u";
    } else if(Collections.frequency(list, "vg")>=2) {
        return "vg";
    } else {
        return "g";
    }
}