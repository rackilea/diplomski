class sortVectors implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {
        // TODO Auto-generated method stub
        if(o1<02){
            return -1;
        }else if(o1>o2)
            return 1;
            return 0;
    }
}
public class sortVector{
    public static void main(String[] args) {
        // TODO Auto-generated method stub
         Vector<Integer> vect = new Vector<Integer>();
            System.out.println("Befor sorting");
            for (int index = 0; index < 10; index++) {
                int rand = (int) (1000 * Math.random());
                vect.add(rand);
                System.out.println(rand);
            }
        Collections.sort(vect,new sortVectors());
        System.out.println("After Sorting");
        for (Integer num : vect) {
            System.out.println(num);
        }

    }

}