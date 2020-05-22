Node child  = new Node();       
    child.setName("Employee");

    List<Node> list = new ArrayList<Node>();
    Node subChild  = new Node();        
    subChild.setName("Subho");
    list.add(subChild);

    subChild  = new Node();     
    subChild.setName("jeet");



    List<Node> sublist = new ArrayList<Node>();
    Node subsubChild  = new Node();     
    subsubChild.setName("Subho");
    sublist.add(subsubChild);
    subsubChild  = new Node();      
    subsubChild.setName("Subho");
    sublist.add(subsubChild);


    subChild.setChildren(sublist);
    list.add(subChild);

    child.setChildren(list);

    Gson gson = new Gson();

    String output = gson.toJson(child);