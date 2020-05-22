public static void main(String[] args) {
    String[] dataItems = {"DataItem {"
            + "ItemId='324e9c2b-2db0-407b-9ec8-66b707b2047f',"
            + "SortPosition='2',"
            + "Rname \"Domino's Pizza\","
            + "LatLat'sf_photo',"
            + "LomgLong'1',"
            + "Neighborhood 'flipstreet',"
            + "Category 'fast-food',"
            + "Address'Taif Street, Dhahrat Laban, Riyadh 12564'}",
            "DataItem    {"
            + "ItemId='e8b0e814-f9e0-4eb8-ae2f-b118f6b4e55d',"
            + "SortPosition='6',"
            + "Rname'بيت الشواية',"
            + "LatLat'sf_photo',"
            + "LomgLong'1',"
            + "Neighborhood 'takhassusi',"
            + "Category 'Arabian',"
            + "Address '2506 Bilal Ibn Rabah, Tuwaiq, Riyadh 14921'"
            + "}"
    };

    String srchString="Neighborhood 'flipstreet'";

    for(String dataNode : dataItems) {
        if(dataNode.contains(srchString)){
            System.out.println(dataNode);
        }
    }
}