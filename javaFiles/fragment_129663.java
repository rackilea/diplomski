public class MapCreator{
    private static Map theOnlyMap;
    public synchronized Map createMap(char mapType){
        if( theOnlyMap != null ) return theOnlyMap;
        switch(mapType){
            case 'S':
                theOnlyMap = new SafeMap();
                 break;
            case 'H':
                theOnlyMap =  new HazardousMap();
                break;
            case 'W':
                theOnlyMap = new WeirdMap();
                break;
        }
        return theOnlyMap;
    }
}