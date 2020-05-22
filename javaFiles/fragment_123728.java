public class BreakfastListAdapter extends BaseAdapter {


private Context context;
private String[] number;
private int[] imageid;

ImageView plus1, minus1;
TextView value1;
int a[];

public BreakfastListAdapter(Context c, String[] number, int[] imageid) {
    context = c;
    this.imageid = imageid;
    this.number = number;
    this.a = new int[number.length];
}

@Override
public int getCount() {
    return number.length;
}

@Override
public Object getItem(int position) {
    return position;
}

@Override
public long getItemId(int position) {
    return 0;
}

@Override
public View getView(final int position, View convertView, ViewGroup parent) {

    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    if (convertView == null) {
        // convertView = new View(context);
        convertView = inflater.inflate(R.layout.secondadapter, null);
    }
    TextView textView = (TextView) convertView.findViewById(R.id.text);
    ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView1);

    plus1 = (ImageView) convertView.findViewById(R.id.plus);
    minus1 = (ImageView) convertView.findViewById(R.id.minus);
    value1 = (TextView) convertView.findViewById(R.id.value);
    textView.setText(number[position]);
    imageView.setImageResource(imageid[position]);
    value1.setText(String.valueOf(a[position]));
    System.out.println(a[position] + "dddddddddddddd");

    plus1.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            a[position] = a[position] + 1;
            value1.setText(String.valueOf(a[position]));
            Toast.makeText(context, String.valueOf(a[position]), 1000).show();
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@");
            System.out.println(a[position]);
            notifyDataSetChanged();
        }

    });
    return convertView;


   }

}