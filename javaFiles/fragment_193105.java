public static void main(String[] args) {
    Integer[] val1 = {1,2,3};
    Integer[] val2 = {1,2,3,3,3};
    Integer[] val3 = {1,2};
    ArrayList<Integer[]> c = new ArrayList<Integer[]>(); 
    c.add(val1);
    c.add(val2);
    c.add(val3);
    int answ = findBiggest(c);
    System.out.println(answ);
}

public static int findBiggest(ArrayList<Integer[]> list){
    int biggestSize = 0
    int biggestPos = -1;
    int i = 0;
    for(Integer[] el : list){
        if(el.length >= biggestSize){
            biggestSize = el.length;
            biggestPos = i;
        }
        i++;
    }

    return biggestPos;
}