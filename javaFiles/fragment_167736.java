JScrollPane scroller = new JScrollPane(table);      
    f.add(scroller); 
    f.add(table); //<- remove this line

    ..

    JScrollPane scrollPane = new JScrollPane(table); //<- remove this line too (scrollPane variable is never used or added to the frame)