public class Test {

/**
 * @param args
 */
public static void main(String[] args) {


    // Loaded Hashmap-------------------------------------------------------------------

    HashMap<Long, String> someMap= new HashMap<Long, String>();
    someMap.put(1L, "variable1");
    someMap.put(2L, "variable2");
    someMap.put(3L, "variable3");
    someMap.put(4L, "variable4");
    someMap.put(5L, "variable5");


    // List getting from db-------------------------------------------------------------------

    List<SomeVO> existingSomeNumberAndShortDescriptionList  = new ArrayList<SomeVO>();

    SomeVO someVO1=new SomeVO();
    someVO1.setSomeNumber(1L);
    someVO1.setShortDesc("Description 1");

    SomeVO someVO2=new SomeVO();
    someVO2.setSomeNumber(2L);
    someVO2.setShortDesc("Description 2");

    existingSomeNumberAndShortDescriptionList.add(someVO1);
    existingSomeNumberAndShortDescriptionList.add(someVO2);

    //--------------------------------------------------------------------------------------------


    HashMap<String, String> hashmap1 =new HashMap<String, String>();
    HashMap<Long, String> hashmap2 =new HashMap<Long, String>();

    //Iterate through list of bean
    for (Iterator<SomeVO> iterator = existingSomeNumberAndShortDescriptionList .iterator(); iterator.hasNext();) {
        SomeVO someVO = (SomeVO) iterator.next();

        // Compare key with main hashmap and Put in hashmap 1
        hashmap1.put(someMap.get(someVO.getSomeNumber()),someVO.getShortDesc());

        // Compare key with main hashmap and check if number exists and Put in hashmap 2
        if(someMap.containsKey(someVO.getSomeNumber()))
            hashmap2.put(someVO.getSomeNumber(),"Y");
        else
            hashmap2.put(someVO.getSomeNumber(),"N");
    }


    // print hashmaps
    System.out.println(hashmap1);
    System.out.println(hashmap2);

}