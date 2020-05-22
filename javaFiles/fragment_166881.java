// create an empty array list with an initial capacity
ArrayList<Namer> arrlist = new ArrayList<Namer>( );

Namer namer1= new Namer("1","A","G");
Namer namer2= new Namer("2","E","G");
Namer namer3= new Namer("3","F","G");

// use add() method to add values in the list
arrlist.add(namer1);
arrlist.add(namer2);
arrlist.add(namer3);

arrlist.remove(namer3);