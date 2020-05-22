Map<Integer,TextView> textViewMap = new HashMap<Integer,TextView>();

public void addTextView(int belowId, int id,String text){
    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT);
    lp.addRule(RelativeLayout.BELOW, belowId);
    lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);

    TextView tv = new TextView(this);
    tv.setLayoutParams(lp);
    tv.setId(id);

    tv.setText(text+"\n");

    textViewMap.put(tv.getId(), tv);
}

public void showview(int id){
    RelativeLayout rSub= (RelativeLayout) findViewById(R.id.rSub);
    rsub.addview(textViewMap.get(id));
}