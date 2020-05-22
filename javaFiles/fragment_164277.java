public class SellContainer{
    private ArrayList<Sell> sales;
    private static int idS=0;
    private static SellContainer instance=null;

    public SellContainer(){
        sales = new ArrayList<>();
    }

    public static SellContainer getInstance(){
        if(instance == null){
            instance = new SellContainer();
        }
        return instance;
    }