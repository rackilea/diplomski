import java.util.ArrayList;
import java.util.List;

public class Package {

    static List<Item> my_pack;

    public static int fillPackage(double weight, ArrayList<Item> item, List<Item> optimalChoice, int n){
        //base case
        if(n == 0 || weight == 0)
            return 0;

        if(item.get(n-1).getWeight() > weight) {
            List<Item> subOptimalChoice = new ArrayList<>();
            int optimalCost =fillPackage(weight, item, subOptimalChoice, n-1);
            optimalChoice.addAll(subOptimalChoice);
            return optimalCost;
        }
        else{
            List<Item> includeOptimalChoice = new ArrayList<>();
            List<Item> excludeOptimalChoice = new ArrayList<>();
            int include_cost = item.get(n-1).getCost() + fillPackage((weight-item.get(n-1).getWeight()), item, includeOptimalChoice, n-1);
            int exclude_cost = fillPackage(weight, item, excludeOptimalChoice, n-1);
            if(include_cost > exclude_cost){
                optimalChoice.addAll(includeOptimalChoice);
                optimalChoice.add(item.get(n - 1));
                return include_cost;
            }
            else{
                optimalChoice.addAll(excludeOptimalChoice);
                return exclude_cost;
            }
        }
    }

    public static void main(String args[]) {
        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(new Item(2, 1));
        itemList.add(new Item(5, 6));
        itemList.add(new Item(3, 2));
        itemList.add(new Item(4, 4));
        itemList.add(new Item(7, 7));

        printOptimalChoice(itemList, 9);
        printOptimalChoice(itemList, 10);
        printOptimalChoice(itemList, 11);
    }

    private static void printOptimalChoice(ArrayList<Item> itemList, double weight) {
        my_pack = new ArrayList<>();
        fillPackage(weight, itemList, my_pack, itemList.size());
        System.out.println("Best choice for weight: " + weight);
        for(int i = 0; i < my_pack.size(); i++) {
            System.out.println(my_pack.get(i));
        }
    }
}