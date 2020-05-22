public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);

    // Get a layout inflater (inflater from getActivity() or getSupportActivity() works as well)
    LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    if(// new orientation is potrait){
        // load potrait layout
    }else{
       // load landscape layout
    }
}