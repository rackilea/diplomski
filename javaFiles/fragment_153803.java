public void turnForward(int pages) {
    currentPage += numOfPages;
}

public void turnBack(int numOfPages) {
    currentPage -= numOfPages;
}

public int getCurrentPage() {
    return currentPage;
}