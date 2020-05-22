public class Mapping {

    Map<String, String> coMap;
    List<String> coList;

    public Mapping() 
    {
        init();
    }

    public static void main(String[] args) 
    {
        Mapping oMapping = new Mapping();

        Map<String, Map<String, String>> oMap = oMapping.classifyMapEntries();

        for ( String sParentKey : oMapping.coList )
        {
            Map<String, String> oChildMap = oMap.get(sParentKey);
            Iterator<String> oIterator = oChildMap.keySet().iterator();

            System.out.println("Map");
            while( oIterator.hasNext() )
            {
                String sChildKey = oIterator.next();
                System.out.print( "Key: " + sChildKey + ", Value: " 
                                    + oChildMap.get(sChildKey) + "\n");
            }
        }
    }

    private void init()
    {
        coMap = new HashMap<String, String>();
        coList = new ArrayList<String>();

        coMap.put("1_1", "a");
        coMap.put("1_19", "a");
        coMap.put("10_1", "b");
        coMap.put("10_19", "b");
    }

    private Map<String, Map<String, String>> classifyMapEntries()
    {
        Map<String, Map<String, String>> oClassified = 
            new HashMap<String, Map<String,String>>();

        Iterator<String> oIterator = coMap.keySet().iterator();
        while( oIterator.hasNext() )
        {
            String sKey = oIterator.next();

            String sFirst = sKey.substring(0,sKey.indexOf("_"));
            if ( !coList.contains(sFirst) )
            {
                coList.add(sFirst);
            }
        }

        for ( String sKey : coList )
        {
            Map<String, String> oChildMap = new HashMap<String, String>();

            Iterator<String> oIterator2 = coMap.keySet().iterator();
            while( oIterator2.hasNext() )
            {
                String sChildKey = oIterator2.next();
                String sParentKey = sChildKey.substring(0,sChildKey.indexOf("_"));

                if ( sKey.equals(sParentKey) )
                {
                    oChildMap.put(sChildKey, coMap.get(sChildKey));
                }
            }

            oClassified.put(sKey, oChildMap);
        }

        return oClassified;
    }

}