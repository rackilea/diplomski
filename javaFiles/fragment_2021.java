OnClickListener oclShareQuote = new OnClickListener() {
    @Override
    public void onClick(View v) {
//Set the text based on the selected button and send it to function vfShareQuote
    switch (v.getId()) {
    case id1:
        vfShareQuote(getResources().getText(R.string.name_agafon)+":\n"+getResources().getText(R.string.agafon_1));
        break;
    case id2:
        vfShareQuote(getResources().getText(R.string.name_agafon)+":\n"+getResources().getText(R.string.agafon_2));
        break;
    }
    }
};