// collect the IDs of the book loans in a set - this makes lookup faster 
Set<String> loanedBookIds = HashSet<>();
for (BookLoan loan : bookLoans) {
    loanedBookIds.add(loan.getBookId());
}

// put the names of unloaned books here
List<String> unloanedTitles = new ArrayList<>();
for (Book book : books) {
    // add all books whose IDs are not in `loanedBookIds`
    if (!loanedBookIds.contains(book.getId())) {
        unloanedTitles.add(book.getTitle());
    }
}

// show titles in the ComboBox
currentView.comboBox(unloanedTitles);