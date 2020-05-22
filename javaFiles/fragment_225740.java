public class SpecialAdapter extends SimpleAdapter {
    private int[] colors = new int[] {Color.RED, Color.GREEN };

    private int[] State= new int[] {1,1,1,1,1,1,0,0,0,0};


    public SpecialAdapter(Context context, List<HashMap<String, String>> items, int resource, String[] from, int[] to) {
        super(context, items, resource, from, to);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      View view = super.getView(position, convertView, parent); 

view.setBackgroundColor(colors[State[position]]);

      return view;
    }
}