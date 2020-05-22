public class SpinnerAdapter extends BaseAdapter{

Context context;

ArrayList<String> list;

LayoutInflater layoutInflater;

SpinnerAdapter(Context context, ArrayList<String> list)
{
    layoutInflater = LayoutInflater.from(context);

    this.list = list;

    this.context = context;
}


@Override
public int getCount()
{
    return list.size();
}

@Override
public Object getItem(int position)
{
    return list.get(position);
}

@Override
public long getItemId(int position)
{
    return list.indexOf(position);
}

@Override
public View getView(int position, View convertView, ViewGroup parent)
{

    convertView = layoutInflater.inflate(R.layout.spinner_s,null);

    TextView client = (TextView) convertView.findViewById(R.id.client);

    client.setText(list.get(position).toString());

    return convertView;
}