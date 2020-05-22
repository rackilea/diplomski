public static ArrayList<String> getVideoIds(ArrayList<String> urls){
    ArrayList<String> ids = new ArrayList<String>();

    for (String url : urls) {
        ids.add(url.substring(url.indexOf('=')+1, url.indexOf('&')));
    }

    return ids;
}