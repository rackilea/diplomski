@Override
    public int getItemViewType(int position) {

        if(empty)
            return EMPTY_VIEW_TYPE_CODE;

        return REGULAR_VIEW_TYPE_CODE;
    }