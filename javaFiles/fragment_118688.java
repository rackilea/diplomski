button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View arg0) {

        textview.setVisibility(textview.getVisibility() == View.VISIBLE ? View.GONE : View.VISIBLE);
        // which is just like:
        /*
        if(textview.getVisibility() == View.VISIBLE)
             textview.setVisibility(View.GONE);
        else
             textview.setVisibility(View.VISIBLE);
        */
    }
});