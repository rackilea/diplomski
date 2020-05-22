public class AdapterListViewEncyclopedia extends ArrayAdapter<Apple> {

private int layoutResourceId;
private Context context;
private List<Apple> data;
private CellHolder holder;

public AdapterListViewEncyclopedia(Context context, int layoutResourceId, List<Apple> data) {
    super(context, layoutResourceId, data);
    this.layoutResourceId = layoutResourceId;
    this.context = context;
    this.data = data;
}


static class CellHolder
{
    ImageView imageApple;
    TextView tvCellAppleName;
}

@Override
public View getView(final int position, View convertView, ViewGroup parent)
{
    View row = convertView;

    if(row == null)
    {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);

        holder = new CellHolder();
        holder.imageApple = (ImageView) row.findViewById(R.id.imageApple);
        holder.tvCellAppleName = (TextView)row.findViewById(R.id.tvAppleName);
        row.setTag(holder);
    }
    else
    {
        holder = (CellHolder)row.getTag();
    }
    // you can set the data here 
    setData(position,holder);

    return row;
}
private void setData(int position, CellHolder holder)
{
    ImageLoader imageLoader = ImageLoader.getInstance();
    imageLoader.displayImage(InterfaceConfig.serverURL+data.get(position).getImageURL(), holder.imageApple);

    holder.tvCellAppleName.setText(data.get(position).getName());
}
}