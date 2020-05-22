TinyDB tinydb=new TinyDB(context);

// store Arraylist<Integer> list;
tinydb.putListInt("yourkey",list);

// retrive Arraylist<Integer>
Arraylist<Integer> list=tinydb.getListInt("yourkey");