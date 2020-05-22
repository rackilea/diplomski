public void getParticularBook(String nameOfBook){
    getBooksWithPredicate(b -> b.getTitle().equalsIgnoreCase(nameOfBook), "");
}

public void getBooksDataOnRange(int from, int to){
    getBooksWithPredicate(b -> b.getIssueYear() >= from && b.getIssueYear() <= to, "No books in range of: " + from + "-" + to);
}

public void getBooksDataOnType(String type){
    getBooksWithPredicate(b -> b.getType().equalsIgnoreCase(type), "No books of type: " + type);
}