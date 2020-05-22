import java.util.*;
class  SortLastName
{
    public static void main(String[] args) 
    {
        List<String> list= new ArrayList<String>();
        list.add("John smith");
        list.add("Albert kennedy");
        list.add("John dsouza");
        System.out.println("Before sorting :"+list);
        Collections.sort(list,new myComparator());
        System.out.println("After sorting :"+list);
    }
    static class myComparator implements Comparator<String>
    {
        public int compare(String str1,String str2)
        {
            String[] tokens1 = str1.split("\\s+");
            String[] tokens2 = str2.split("\\s+");
            int i = tokens1[1].compareTo(tokens2[1]);
            return i;
        }
    }
}