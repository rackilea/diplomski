public ArrayList<String> getSLTag(String hltag) {
    List<String> slTags = new ArrayList<String>();
    for(int i = 0; i < xmlTagInfo.size(); i++) {
        if( xmlTagInfo.get(i).hltag == hltag ) {
            for (SubChild child : xmlTagInfo.get(i).sltag) {
                // Your SubChild class actually declares path and name to be an ArrayList of Strings, but surely they should just be Strings?
                slTags.add(child.getPath());
            }
        }
    }
    return slTags;
}