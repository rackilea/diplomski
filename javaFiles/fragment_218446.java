BOM model = new BOM();
 Item child = model.getChildItem(); 
 // you now have a handle to the child object. Presumably, so does model, but we don't care about that.
 ArrayList a = new ArrayList();
 a.add(child); 
//a now has a handle to child.
 model.close();
 // child is not eligible for garbage collection because a still has a handle to it.