@Override
    public View getChildView(int groupPosition, int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater = getLayoutInflater();
            row = inflater.inflate(R.layout.row_child,
                    parent, false);
        }

        TextView textOne = (TextView) row
                .findViewById(R.id.text_row_child1);
        TextView textTwo = (TextView) row
                .findViewById(R.id.text_row_child2);

        HandleOnClick handleOnClick = new HandleOnClick (
                groupPosition, childPosition, getChildId(groupPosition,
                        childPosition));
        textOne.setOnClickListener(handleOnClick);
        textTwo.setOnClickListener(handleOnClick);

        return super.getChildView(groupPosition, childPosition,
                isLastChild, row, parent);
    }

    private class HandleOnClick implements OnClickListener {
        private int groupPosition;
        private int childPosition;
        private Long id;

        public HandleOnClick (int groupPostion, int childPosition,
                Long id) {
            this.groupPosition = groupPostion;
            this.childPosition = childPosition;
            this.id = id;
        }

        public void onClick(View v) {

            idChild = id; 
            switch (v.getId()) {

            case R.id.text_row_child1:


                break;


            case R.id.text_row_child2:

                //........