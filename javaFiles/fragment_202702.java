public String listCounty(String county) {
    boolean matchFound = false;
    String displayPropertys = "All Propertys";

    for (int index = 0; index < house.length; index++) {
        Property item = house.get(index)
        if (item.getGeneralLocation().equals(county)) {
            displayPropertys += "\n" + (index + 1) + item;
            matchFound = true;
        } 
    }

    if (!matchFound)
        return "No propertys for this County";
    else
        return displayPropertys;
}