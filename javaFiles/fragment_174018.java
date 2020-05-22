public class subMyListAdapter extends BaseAdapter{
Context context;
LayoutInflater Inflater;
ArrayList<subMyItem> arraySrc;
int layout;
static int currentTheme = 0;
EditText tvItem;
RelativeLayout rl_inflate;
UserHolder holder;
public subMyListAdapter(Context context, int layout, ArrayList<subMyItem> arraySrc)
{
    this.context = context;
    this.layout = layout;
    this.arraySrc = arraySrc;
    Inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
}
public int getCount()
{
    return arraySrc.size();
}
public String getItem(int position)
{
    return arraySrc.get(position).list;
}
public long getItemId(int position)
{
    return position;
}
public View getView(final int position, View conv, ViewGroup parent)
{
    holder = null;
     if (conv == null) 
     {
       LayoutInflater inflater = ((Activity) context).getLayoutInflater();
       conv = inflater.inflate(layout, parent, false);
       holder = new UserHolder();
       holder.tvItem = (EditText)conv.findViewById(R.id.tvItem);
       conv.setTag(holder);
     }
     else 
     {
       holder = (UserHolder) conv.getTag();
     }
     if(holder == null)
     {
       holder = new UserHolder();
       holder.tvItem = (EditText)conv.findViewById(R.id.tvItem);
       conv.setTag(holder);
     }
     subMyItem user = arraySrc.get(position);
     holder.tvItem.setOnTouchListener(test);
     conv.setOnTouchListener(test);
    if(conv == null)
    {
        conv = conv;
    }
    tvItem = (EditText) conv.findViewById(R.id.tvItem);
    user = arraySrc.get(position);
    tvItem.setText(user.list);
    tvItem.setOnClickListener(new View.OnClickListener() 
     {
       @Override
       public void onClick(View v) 
       {
           Toast.makeText(context, "tvItem button Clicked",
           Toast.LENGTH_LONG).show();
       }
    });
    return conv;
}
View.OnTouchListener test=  new View.OnTouchListener() 
{
    @Override
    public boolean onTouch(View view, MotionEvent event) 
    {
        if (view instanceof EditText) 
        {
            EditText editText = (EditText) view;
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
        } else 
        {
            UserHolder holder = (UserHolder) view.getTag();
            holder.tvItem.setFocusable(false);
            holder.tvItem.setFocusableInTouchMode(false);
        }
    return false;
    }
};
 static class UserHolder 
 {
      EditText tvItem;
     }
 }