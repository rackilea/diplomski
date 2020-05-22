public class Benildus_Adapter extends ArrayAdapter<Person> {

ArrayList<Person> list; // your person arraylist
Context context; // the activity context
int resource; // this will be your xml file

public Benildus_Adapter(Context context, int resource,ArrayList<Person> objects) {
    super(context, resource, objects);
    // TODO Auto-generated constructor stub
    this.list = objects;
    this.context = context;
    this.resource = resource;
}

@Override
public int getCount() {
    // TODO Auto-generated method stub
    if(list.size() == 0){
        return 0;
    }else{
        return list.size();
    }
}

@Override
public View getView(final int position, View convertView, ViewGroup parent) {
    // TODO Auto-generated method stub
    View child = convertView;
    RecordHolder holder;
    LayoutInflater inflater = ((Activity) context).getLayoutInflater(); // inflating your xml layout

    if (child == null) {            
        child = inflater.inflate(resource, parent, false);
        holder = new RecordHolder();
        holder.fname = (TextView) child.findViewById(R.id.fname); // fname is the reference to a textview
        holder.lname = (TextView) child.findViewById(R.id.lname); // in your xml layout file 
        holder.bio =(TextView) child.findViewById(R.id.bio); // you are inflating.etc
        child.setTag(holder);
    }else{
        holder = (RecordHolder) child.getTag();
    }

    final Person user = list.get(position); // you can remove the final modifieer.

    holder.fname.setText(user.getFName());      
    holder.lname.setText(user.getLName());
    holder.bio.setText(user.getBiography());
    holder.image.setImageBitmap(user.getImage()); // if you use string then you download the image using
    // the string as url and set it to your imageview..
    return child;
}

static class RecordHolder {
    TextView fname,lname,bio;
    ImageView image;    
}


@Override
public void notifyDataSetChanged() { // you can remove this..
    // TODO Auto-generated method stub      
    if(getCount() == 0){
        //show layout or something that notifies that no list is in..
    }else{
        // this is to make sure that you can call notifyDataSetChanged in any place and any thread
        new Handler(getContext().getMainLooper()).post(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                Benildus_Adapter.super.notifyDataSetChanged();
            }
        });
    }
}

}