public class CustomAdapter extends BaseAdapter {
    String [] result;
    Context context;
    private static LayoutInflater inflater=null;
    public CustomAdapter(MainActivity activity, String[] prgmNameList) {

        result = prgmNameList;
        context = activity;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tv;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Holder holder=new Holder();
        View rowView = inflater.inflate(R.layout.list_item, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView1);
        //holder.tv.setText(result[position]);

        String span[] = result[position].split(" ") ;

        SpannableString ss = new SpannableString(result[position]);

        ClickableSpan spans[] = new ClickableSpan[span.length];

        for(int spanCount = 0 ; spanCount < span.length ; spanCount++){
            spans[spanCount] = new ClickableSpan() {
                @Override
                public void onClick(View textView) {

                    TextView v = (TextView)textView ;
                    String text = v.getText().toString() ;

                    Log.d("View" , text);
                }
            };
        }

        int start = 0 ;
        int end ;
        try {
            for(int spanCount = 0 ; spanCount < span.length ; spanCount++){
                end = span[spanCount].length()-1 ;
                ss.setSpan(spans[spanCount], start, end , Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                start = span[spanCount].length()+1;
                end = span[spanCount].length() + 2 + end ;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.tv.setText(ss);

        Log.d("SpannableString" , ss.toString());

        return rowView;
    }

}