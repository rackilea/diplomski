public class MapAdapter extends RecyclerView.Adapter<MapAdapter.MyHolder> {
    HashMap<String, List<Data>> dataList;
    Context context;
    private SparseBooleanArray expandState = new SparseBooleanArray();

    public MapAdapter(Context context, HashMap<String, List<Data>> dataList) {
        this.dataList = dataList;
        this.context = context;
        for (int i = 0; i < dataList.size(); i++) {
            expandState.append(i, false);
        }

    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_map, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        holder.setIsRecyclable(false);
        holder.textView_name.setText(getHashMapKeyFromIndex(dataList, position));
        final boolean isExpanded = expandState.get(position);
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

        Log.e("val", "" + dataList.get(getHashMapKeyFromIndex(dataList, position)).size());
        //llContainer
        holder.llContainer.removeAllViews();
        double sum = 0;
        LayoutInflater layoutInflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i = 0; i < dataList.get(getHashMapKeyFromIndex(dataList, position)).size(); i++) {
            Log.e("VALL", dataList.get(getHashMapKeyFromIndex(dataList, position)).get(i).title);
            View view = layoutInflator.inflate(R.layout.row_subcat_child, null);
            TextView tv_title = view.findViewById(R.id.tv_title);
            TextView tv_price = view.findViewById(R.id.tv_price);
            tv_title.setText(dataList.get(getHashMapKeyFromIndex(dataList, position)).get(i).title);
            tv_price.setText(String.valueOf(dataList.get(getHashMapKeyFromIndex(dataList, position)).get(i).price));
            sum = sum + dataList.get(getHashMapKeyFromIndex(dataList, position)).get(i).price;
            holder.llContainer.addView(view);
        }
        holder.textView_total.setText(""+sum);
        Log.d("sum",""+sum);

        holder.buttonLayout.setRotation(expandState.get(position) ? 180f : 0f);
        holder.buttonLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                onClickButton(holder.expandableLayout, holder.buttonLayout, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView textView_name,textView_total;
        LinearLayout expandableLayout, llContainer;
        RelativeLayout buttonLayout;

        public MyHolder(View view) {
            super(view);
            textView_total = view.findViewById(R.id.textView_total);
            textView_name = view.findViewById(R.id.textView_name);
            expandableLayout = view.findViewById(R.id.expandableLayout);
            buttonLayout = view.findViewById(R.id.button);
            llContainer = view.findViewById(R.id.llContainer);
        }
    }

    public static String getHashMapKeyFromIndex(HashMap hashMap, int index) {

        String key = null;
        HashMap<String, Object> hs = hashMap;
        int pos = 0;
        for (Map.Entry<String, Object> entry : hs.entrySet()) {
            if (index == pos) {
                key = entry.getKey();
            }
            pos++;
        }
        return key;
    }

    private ObjectAnimator createRotateAnimator(final View target, final float from, final float to) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotation", from, to);
        animator.setDuration(300);
        animator.setInterpolator(new LinearInterpolator());
        return animator;
    }

    private void onClickButton(final LinearLayout expandableLayout, final RelativeLayout buttonLayout, final int i) {

        //Simply set View to Gone if not expanded
        //Not necessary but I put simple rotation on button layout
        if (expandableLayout.getVisibility() == View.VISIBLE) {
            createRotateAnimator(buttonLayout, 180f, 0f).start();
            expandableLayout.setVisibility(View.GONE);
            expandState.put(i, false);
        } else {
            createRotateAnimator(buttonLayout, 0f, 180f).start();
            expandableLayout.setVisibility(View.VISIBLE);
            expandState.put(i, true);
        }
    }

}