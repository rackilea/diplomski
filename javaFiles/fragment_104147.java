public View getView(int position, View convertView, ViewGroup parent)
{
    LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rowView = inflater.inflate(this.layout, parent, false);

    SomeObject obj = (SomeObject)data[position];

    // Then access like so:
    SomeView sv = (SomeView)rowView.findViewById(R.id.some_view);
    // then access methods and properties as you normally would.
}