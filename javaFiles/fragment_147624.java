public static String[] getMixedRandomNumbers(int size) {
    String[] private_array = {"105", "21", "57", "60", "103", "108", "111", "113", "116", "173", "104"};
    String[] public_array  = {"103", "44", "3"};
    List<String> priv = Arrays.asList(private_array);
    List<String> publ = Arrays.asList(public_array);
    Collections.shuffle(priv);
    Collections.shuffle(publ);
    List<String> result = new ArrayList<>();
    result.addAll(priv);
    for(String p : publ){
        if(!result.contains(p)){
            result.add(p);
        }
    }        
    int i = Math.min(size, result.size());
    return result.subList(0, i).toArray(new String[i]);
}