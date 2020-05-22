private View firstClicked = null;

private OnClickListener swapImages = new OnClickListener() {

    @Override
    public void onClick(View v) {
        if(firstClicked != null){
            LayoutParams p1 = firstClicked.getLayoutParams();
            LayoutParams p2 = v.getLayoutParams();
            v.setLayoutParams(p1);
            firstClicked.setLayoutParams(p2);
                            firstClicked = null;
        }
        else 
            firstClicked = v;
    }
};