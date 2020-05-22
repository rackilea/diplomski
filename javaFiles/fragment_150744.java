public View getView(int position, View convertView, ViewGroup parent)
    {
        convertView = super.getView(position, convertView,  parent);
        if(condition){
            convertView.setBackgroundColor(getResources().getColor(R.color.dark));
        }
        else
        {
            convertView.setBackgroundColor(getResources().getColor(R.color.bright));
        }
        return convertView;
    }