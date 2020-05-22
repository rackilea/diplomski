private static int GetItemsInCommaSeparatedList(){

    String param = ""; // "1,2,3" returns 3 without issue
    Pattern p = Pattern.compile("\\s*,\\s*");
    Matcher m = p.matcher(param);
    List<String> items = new ArrayList<String>();
    if(m.find()){
        System.out.println("Found");
        items = Arrays.asList(param.split("\\s*,\\s*"));
    }

    if ( items.isEmpty() )
        return 0;
    return items.size();
}