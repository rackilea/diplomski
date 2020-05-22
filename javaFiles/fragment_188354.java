//Make list before so its within scope
ArrayList ls = new ArrayList<Point>();

for(int i=0; i < numOfObjectsToMake; i++){
    Point p = new Point();//make whatever object
    p.x = valX; //set what ever here
    p.y = valY; //set what ever here
    ls.add(p);//Problem solved i have stored the object
}

ls.get(...);//pull out objects later for use