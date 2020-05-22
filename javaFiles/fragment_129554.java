private void setMatches(ValueChangeEvent event) {
Object searchWord = event.getNewValue();
int maxMatches = ((SelectInputText)event.getComponent()).getRows();
List matchList = new ArrayList(maxMatches);

try {
    for(int i = 0; i < dictionary.size(); i++) {
        SelectItem s = dictionary.get(i);
        if(s.getLabel().startsWith(searchWord)) {
            matchList.add(s);
            if(matchList.size() == maxMatches)
                break;
        }   
    }
} catch (Throwable e) {
    e.printStackTrace();
    logger.error("Erorr finding autocomplete matches" + e.getMessage());
}        
if (this.matchesList != null) {
    this.matchesList.clear();
    this.matchesList = null;
}
this.matchesList = matchList;
}

// note: not optimized, just to explain how to do.