@Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View convertView, ViewGroup viewGroup) {
        ChildRow childRow = (ChildRow) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.expandable_child_list_item, null);



        }

ImageView childIcon = (ImageView) convertView.findViewById(R.id.ivExp);
            childIcon.setImageResource(childRow.getIcon());

            final TextView childTitleText = (TextView) convertView
                    .findViewById(R.id.childTitleText);

            final TextView childAmountText = (TextView) convertView
                    .findViewById(R.id.childAmountText);

            childTitleText.setText(childRow.getTitle().trim());
            childAmountText.setText(childRow.getAmount()+"");


           // final View finalConvertView =convertView;

        return convertView;
    }