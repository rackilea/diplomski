invite.setOnClickListener(new OnClickListener(){
    public void onClick(View v){
        linearlayoutbar1.setVisibility(View.VISIBLE);
        linearlayoutbar2.setVisibility(View.GONE);
    }
});

share.setOnClickListener(new OnClickListener(){
    public void onClick(View v){
        linearlayoutbar2.setVisibility(View.VISIBLE);
        linearlayoutbar1.setVisibility(View.GONE);
    }
});