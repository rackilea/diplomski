public class coffee_adapter extends ArrayAdapter<coffee> {
    private ArrayList<coffee> coffeeList;
    public coffee_adapter(Context context, ArrayList<coffee> cof) {
        super(context, 0, cof);
        this.coffeeList = cof;
    }
    public reset(ArrayList<coffee> baseCoffeeList){
        coffeeList.clear();
        coffeeList.addAll(baseCoffeeList);
        notifyDataSetChanged();
    }
}