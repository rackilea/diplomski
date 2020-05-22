public class CuisineAdapter{

    private ArrayList<CuisineCategory> mydataList;

    public CuisineAdapter(Context context, ArrayList<CuisineCategory> mydataList) {
            this.context = context;
            this.mydataList = mydataList;
    }

    public CuisineAdapter(Context context, 
                          ArrayList<CuisineCategory> mydataList, 
                          CuisineListToggleListener listToggleListener) {
            this(context, mydataList);
            this.listToggleListener = listToggleListener;
    }

    public CuisineAdapter(Context context, 
                          CuisineListToggleListener listToggleListener) {
            this.context = context;
            this.listToggleListener = listToggleListener;
    }

    public ArrayList<CuisineCategory> getMydataList(){
       return mydataList;
    }

    public void setMydataList(ArrayList<CuisineCategory> mydataList){
       this.mydataList= mydataList;
    }

  }