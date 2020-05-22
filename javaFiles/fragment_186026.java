Bundle bundle = getIntent().getExtras();
if (bundle != null) {
    if(bundle.containsKey("highlegs")){
    String text = bundle.getString("highlegs");
    }
    if(bundle.containsKey("legcurls")){
    String text = bundle.getString("legcurls");
    }


    if (text != null)
        textView.setText(text);

}