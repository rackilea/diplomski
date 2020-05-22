public int compare(TypeToBeSorted o1, TypeToBeSorted o2) {
    int comByTitle = (sortByTitle == null ) ? 0 : sortByTitle.compare(o1, o2);
    int comByDirector = (sortByDirector == null ) ? 0 : sortByDirector.compare(o1, o2);
    //add logic 
    return ......;
}