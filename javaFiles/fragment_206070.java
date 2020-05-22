MyGrid myGrid = // create your MyGrid object
yourReference.set(myGrid);
//Create your MyColourList objects and set the properties
MyColourList myColourList = new MyColourList();
MyColourList colourListDefault = new MyColourList();
myGrid.setColourList(colourList);
myGrid.setColourListDefault(colourListDefault);
yourReference.set(myGrid, SetOptions.merge());