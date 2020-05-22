mButton.setOnClickListener(new View.OnClickListener(){
    @Override
    public void onClick(View v){
        mCheckoutListener.onClick(); // call the interface method
    }
});