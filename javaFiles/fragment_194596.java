private ArrayList<Fish> _fish; 
private ArrayList<ZFish> _zfish; 

fishInfectedMethod(int indexOfCaughtFish){
    int x = _fish.get(indexOfCaughtFish).getX();
    int y = _fish.get(indexOfCaughtFish).getY();
    _fish.remove(indexOfCaughtFish);
    _zfish.add(new ZFish(new Color(0, 179, 60),_tank, _fish));
    _zfish.setLocation(x, y);
}