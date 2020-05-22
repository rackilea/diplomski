public class TestAdapter extends RecyclerView.Adapter<TestAdapter.VH> {

public static class MyData {
    public boolean Selected = false;
    public String Text;

    public MyData(String text) {
        Text = text;
    }
}

public List<MyData> items = new ArrayList<>();

public TestAdapter() {
    this.items.add(new MyData("Item 1"));
    this.items.add(new MyData("Item 2"));
    this.items.add(new MyData("Item 3"));
}

@Override
public TestAdapter.VH onCreateViewHolder(ViewGroup parent, int viewType) {
    return new VH((
            LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.test_layout, parent, false))
    );
}

@Override
public void onBindViewHolder(TestAdapter.VH holder, int position) {
    final MyData itm = items.get(position);

    holder.button.setChecked(itm.Selected);
    holder.text.setText(itm.Text);

    holder.button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            for (MyData x: items){
                x.Selected=false;
            }
            itm.Selected = true;
            notifyDataSetChanged();
        }
    });

}

@Override
public int getItemCount() {
    return items.size();
}

public class VH extends RecyclerView.ViewHolder {

    ToggleButton button;
    TextView text;

    public VH(View itemView) {
        super(itemView);
        button = itemView.findViewById(R.id.toggle);
        text = itemView.findViewById(R.id.text1);
    }
}
}