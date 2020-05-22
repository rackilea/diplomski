public class FTW {
    public static void main (String[]args){
        Random I  = new Random();
        List<Integer> list = new ArrayList<Integer>();
        int number; 

        for(int counter=1; counter<=20;counter++){
            number = I.nextInt(100);
            while(list.contains(number)) {
                number = I.nextInt(100);
            }
            list.add(number);
        }
        Collections.sort(list); //Sorts the list
        System.out.println(list);
    }
}