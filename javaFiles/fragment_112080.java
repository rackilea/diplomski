public class Test {

    public static ArrayList<Integer> compareArrayandList(ArrayList<Integer>compare, ArrayList<Integer>array2) {
        ArrayList<Integer> a3 = new ArrayList<Integer>();               
        for (Integer a : compare)
        {
            if(array2.contains(a))
                a3.add(a);
        }
            System.out.println(a3);
        return a3;
    }

    public static void main(String[] args) {
        ArrayList<Integer> a1=new ArrayList<Integer>();
        ArrayList<Integer> a2=new ArrayList<Integer>();
        a1.add(1);
        a1.add(5);
        a1.add(3);
        a2.add(3);
        a2.add(4);
        a2.add(5);
        a2.add(6);
        Test test=new Test();
        test.compareArrayandList(a1,a2);

    }

}