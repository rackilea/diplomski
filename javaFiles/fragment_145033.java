public Object instantiateItem(View collection, int position) {
        LayoutInflater inflater = (LayoutInflater)cxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.search_result, null);
        //
        TextView title = (TextView)layout.findViewById(R.id.search_result_title);
        TextView body = (TextView)layout.findViewById(R.id.search_result_body);
        TextView byline = (TextView)layout.findViewById(R.id.search_result_byline);
        TextView day = (TextView)layout.findViewById(R.id.search_result_date_day);
        TextView month = (TextView)layout.findViewById(R.id.search_result_date_month);
        TextView year = (TextView)layout.findViewById(R.id.search_result_date_year);
        //
        title.setText(list_title.get(position).toString());
        body.setText(list_body.get(position).toString());
        day.setText(list_day.get(position).toString());
        month.setText(list_month.get(position).toString());
        year.setText(list_year.get(position).toString());
        byline.setText(list_byline.get(position).toString());
        //
        ((ViewPager) collection).addView(layout,0);
        return layout;
    }