public static ArrayList<Map<Integer, String>> search(final ArrayList<Map<Integer, String>> myMapList, String searchTerm)
    {
        ArrayList<Map<Integer, String>> newListOfMaps = new ArrayList<Map<Integer, String>>();

        for (Map<Integer, String> map : myMapList)
        {

            for (String value : map.values())
            {
                if (value.contains(searchTerm)){
                    newListOfMaps.add(map);
                    break;
                }
            }
        }
        return newListOfMaps;
    }
}