public void add(View v){
    final String input = inputText.getText().toString();
    txt = new TextView(this);

    if(input.matches("")){
        inputText.setBackgroundColor(-65536);
    } else{
        txt.setHeight(50);
        txt.setText(i+". "+input);
        txt.setBackgroundColor(checkedColor);
        i++;
        container.addView(txt);
        colorPick.clearCheck();
        inputText.setText("");
        //Add a edit option
        txt.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                id=txt.getId();
                dialogCustom((TextView) v);
                return false;
            }
        });
    }
}