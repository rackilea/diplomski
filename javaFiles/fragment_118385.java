String[] SEE = ...
Set<String> setSEE = new HashSet<>(Arrays.asList(SEE));
String[] CEE = ...
Set<String> setCEE = new HashSet<>(Arrays.asList(CEE));
for (Data data : list) {
    if (setSEE.contains(data.getPropertyCountry()) {
        data.setMarket("SEE");
    } else if (setCEE.contains(data.getPropertyCountry()) {
        data.setMarket("CEE");
    }
}