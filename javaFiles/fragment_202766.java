// Declare upper bound here.
public static <G extends MinMax> int selRan(ArrayList<G> list){
    int sel = 0;
    Random rand = new Random();
    int  randNum = rand.nextInt(100) + 1;
    for(int i = 0; i < list.size(); i++){
        // Call interface methods here.
        if(list.get(i).getMin() <= randNum && randNum < list.get(i).getMax()){
            sel = i;
        }
    }
    return sel;
}