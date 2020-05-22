public class CustomAdapter extends ArrayAdapter<CustomObject> {

Context context; 
int layoutResourceId;    
ArrayList<CustomObject> data = null;

public CustomAdapter (Context context, int layoutResourceId, ArrayList<CustomObject> data) {
    super(context, layoutResourceId, data);
    this.layoutResourceId = layoutResourceId;
    this.context = context;
    this.data = data;
}

static class ViewHolder
{
    ImageView imgDealImage;
    TextView txtDescription;

}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder = null;

    if(convertView == null)
    {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(layoutResourceId, parent, false);

        holder = new ViewHolder();
        holder.imgDealImage = (ImageView)convertView.findViewById(R.id.imgDealImage);
        holder.txtDescription = (TextView)convertView.findViewById(R.id.txtDescription);


        convertView.setTag(holder);
    }
    else
    {
        holder = (ViewHolder)convertView.getTag();
    }

    int image = data.get(position).getImage();
    String description = data.get(position).getDescription();


    holder.imgDealImage.setImageResource(image);
    holder.txtDescription.setText(description);


    return convertView;
    }

}