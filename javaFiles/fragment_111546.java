@Override public View getView(int position, View view, ViewGroup parent) {
    view = layoutInflater.inflate(R.layout.article_each,parent,false);//the good way
    TextView titleView =(TextView)view.findViewById(R.id.title);

    HashMap<String, String> eacharticle = articleList.get(position);

    if(eacharticle != null ) {
        String title = eacharticle.get("title");
        titleView.setText(title);
    }
    return view;
}