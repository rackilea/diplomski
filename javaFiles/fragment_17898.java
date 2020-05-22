Gtk.init(args); //Init library
Builder b = new Builder();  //Create builder
b.addFromFile("filename.glade");  //Load layout from file
Window w = (Window) b.getObject("myWindowName");  //Retrieve an object
w.showAll(); //Show window
Gtk.main();