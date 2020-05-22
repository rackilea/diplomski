public class Holder {
    ButtonRectangle buttonPlus;
    TextView cartQtyTextView;
}

@Override
public View getView(int position, View convertView, ViewGroup parent) {
    // Get Holder
    final Holder holder = new Holder();

    // Change Layout
    LayoutInflater inflater = (LayoutInflater) this.context
                              .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View view = inflater.inflate(R.layout.menu_list_item, null);

    // Find Control
    holder.buttonPlus = (ButtonRectangle)view.findViewById(R.id.buttonPlus);
    holder.cartQtyTextView = (TextView)view.findViewById(R.id.cartQtyTextView);

    // Check & Set
    if (holder.buttonPlus != null) {
        holder.buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 0;
                if (holder.cartQtyTextView != null) {
                    holder.cartQtyTextView.setText("" + ++i);
                }
            }
        });
    }

    return view;
}