// Create a hashtable for String,ImageIcon
Hashtable<String,ImageIcon> table=new Hashtable<>();

    // Add extensions and icons
    table.put(".txt",new ImageIcon("txtfile.png"));
    table.put(".doc",new ImageIcon("docfile.png"));
    table.put(".ppt",new ImageIcon("pptfile.png"));
    table.put(".lnk",new ImageIcon("link.png"));
    table.put(".png",new ImageIcon("image.png"));
    table.put(".gif",new ImageIcon("image.png"));
    table.put(".jpeg",new ImageIcon("image.png"));
    table.put(".jpg",new ImageIcon("image.png"));