private volatile ImmutableMap map;

public config(){
    ImmutableMap newMap = createNewMap();
    this.map = newMap;
}