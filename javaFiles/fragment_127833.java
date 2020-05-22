@Override // i - group position , i1 - child position b - isLastchild
  public View getChildView(final int i, final int i1, boolean b, View view, ViewGroup viewGroup)
  {
    final String childText = (String)getChild(i,i1);
    ViewHolder holder;

    if(view==null)
    {
        LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.expandable_list_items, null);

        holder = new ViewHolder(view);
        view.setTag(holder);
    }

    else
    {
        holder = (ViewHolder)view.getTag();
    }

    holder.ratingbar.setOnRatingBarChangeListener(onRatingChangedListener(holder, i, i1));

    holder.features.setText(childText);
    holder.ratingbar.setTag(i1);
    holder.ratingbar.setRating(arr[i][i1]);

    return view;
}