protected void initPopWin() {
    try { 
        // We need to get the instance of the LayoutInflater 
        LayoutInflater inflater = (LayoutInflater) SinglePlayerGame.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
        View layout = inflater.inflate(R.layout.popup_element,null); 
        nameInput = (EditText) layout.findViewById(R.id.popupName);