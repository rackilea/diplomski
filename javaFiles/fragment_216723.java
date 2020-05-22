import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeMap;

public class MultiValueCollection {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MultiValueCollection mCollection=new MultiValueCollection();
        TreeMap<Integer, LinkedList<Integer>> tMap=new TreeMap<Integer, LinkedList<Integer>>();


        mCollection.addMobileNumberByDistance(tMap, 40, 65655423);
        mCollection.addMobileNumberByDistance(tMap, 40, 76785647);
        mCollection.addMobileNumberByDistance(tMap, 40, 85785852);
        mCollection.addMobileNumberByDistance(tMap, 40, 96786344);
        mCollection.addMobileNumberByDistance(tMap, 40, 57657354);

        mCollection.addMobileNumberByDistance(tMap, 20, 13543353);
        mCollection.addMobileNumberByDistance(tMap, 20, 23453456);

        mCollection.addMobileNumberByDistance(tMap, 30, 33353544);
        mCollection.addMobileNumberByDistance(tMap, 30, 43534554);
        mCollection.addMobileNumberByDistance(tMap, 30, 59789785);


        mCollection.printMobileNumbersByDistance(tMap);
    }

    public void addMobileNumberByDistance(TreeMap<Integer, LinkedList<Integer>> tMap, int distance, int mobileNo)
    {
        LinkedList<Integer> list=null;
        if(tMap.get(distance)==null)
        {
            list=new LinkedList<Integer>();
        }else
        {
            list=tMap.get(distance);
        }
        list.push(mobileNo);
        tMap.put(distance, list);
    }

    public void printMobileNumbersByDistance(TreeMap<Integer,LinkedList<Integer>> distNumberMap)
    {
        LinkedList<Integer> list;
        for(int n : distNumberMap.keySet())
        {
            list=distNumberMap.get(n);
            Collections.sort(list);//Add this line if mobileNo needs to be sorted for a given distance
            for(int k : list)
            {
                System.out.println("key "+n+" value "+k);
            }
        }
    }
}