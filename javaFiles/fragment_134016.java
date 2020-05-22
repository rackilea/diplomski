HashMap<Integer, BookFormatNew> map = new HashMap<>();
for(BookFormat b: book){
    BookFormatNew bfn = map.get(b.getBookId());
    if(bfn == null){
        // Create new EntryPair and add
        BookFormatNew bfn_new = new BookFormatNew(b.getBookId(), b.getBookSeries(), "F","F","F","F","F");
        map.put(b.getBookId(), bfn_new);
        bfn = map.get(b.getBookId());
    }
    if(b.getFormat().equals("A0"){
        bfn.setA0("T");
    }
    else if(b.getFormat().equals("A1"){
        bfn.setA1("T");
    }
    else if(b.getFormat().equals("A2"){
        bfn.setA2("T"); 
    }
    else if(b.getFormat().equals("A3"){
        bfn.setA3("T");
    }
    else if(b.getFormat().equals("A4"){
        bfn.setA4("T");
    }

    map.put(b.getBookId(),bfn);  // Puts updated T,F set
}