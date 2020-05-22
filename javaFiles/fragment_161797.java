StartScreenController s = (StartScreenController)loader.getController();

// so StartScreenController s is null here thus NPE
s.setParent(this);

// here loading is happening after getting the controller class, which is wrong. 
// Get the controller after loading is completed.

Parent root = (Parent) loader.load(location.openStream());