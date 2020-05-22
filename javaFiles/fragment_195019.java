public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<dashboard.Dashboard_info> android;
    private Activity activity;

    public DataAdapter(ArrayList<dashboard.Dashboard_info> android,Activity activity) {
        this.android = android;
        this.activity = activity;
    }