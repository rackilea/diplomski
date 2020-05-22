MuAdapter= new muadapter(Activityname.this);
//  this line is broke. Use something like "MuAdapter muAdapter = new ..." 

mudapter.open();
// then this line can work

ArrayList<String> list =getImagePath();
// not sure about this, but don't you need an objectrefernece here, that you call getImagePath() on?!