public boolean isAllScoresNull() {
    for(Person p : people) {
        if(p.getScore != null) return false;
    }
    return true;
}