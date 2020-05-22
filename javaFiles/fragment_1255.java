public class CategoryAdapter extends BaseAdapter {

ArrayList<String> cat_name;
ArrayList<Integer> images;
private Context mContext;
private LayoutInflater mInflater;
private final String[] gridcolor;

public CategoryAdapter(Context mContext, ArrayList<String> cat_name, ArrayList<Integer> images,String[] gridcolor)
{
    this.mContext = mContext;
    this.cat_name = cat_name;
    this.gridcolor = gridcolor;
    this.images = images;
    mInflater = LayoutInflater.from(mContext);
}

@Override
public int getCount() {
    return images.size();
}

@Override
public Object getItem(int i) {
    return null;
}

@Override
public long getItemId(int i) {
    return 0;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View row = convertView;
    CategoryHolder holder = null;

    if(row == null)
    {
        row = mInflater.inflate(R.layout.category_item, parent, false);
        holder = new CategoryHolder(row);
        row.setTag(holder);
    }
    else
    {
        holder = (CategoryHolder)row.getTag();
    }

    try {
        Picasso.with(mContext)
                .load(images.get(position))
                .placeholder(R.drawable.loading)
                .error(R.drawable.nopicture)
                .into(holder.image);
    } catch (Exception e) {
        Log.d("MYDEBUG3", e.getMessage());
    }
    holder.name.setText(cat_name.get(position));
    holder.layout.setBackgroundColor(Color.parseColor(gridcolor[position]));
    return row;
}