public class GridViewAdapter extends BaseAdapter {
  private final Context context;
  private List<DataClass> data = new ArrayList<>();

  public GridAdapter(Context context) {
    this.context = context;
  }

  public void setData(List<DataClass> data) {
    this.data = data;
    notifyDataSetChanged();
  }

  @Override
  public int getCount() {
    return data.size();
  }

  @Override
  public Object getItem(int i) {
    return data.get(i);
  }

  @Override
  public long getItemId(int i) {
    return i;
  }

  @Override
  public View getView(int i, View view, ViewGroup viewGroup) {
    // usual thing here
  }
}