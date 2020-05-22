public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewHolder> {// Recyclerview will extend to

private List<FileName> fileNames;

  private Context context;

//declare interface 
 private OnItemClicked onClick;

//make interface like this
    public interface OnItemClicked {
        void onItemClick(int position);
    }

  public RecycleViewAdapter(Context context,List<FileName> fileNames) {
    this.context = context;
    this.fileNames = fileNames;
}