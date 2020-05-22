@Override
public onPageSelected(int position) {
    String contentForSnackbar = "default string";
    switch(position){
    case 0:  
      contentForSnackbar = "first fragment";
      break;
    case 1:  
      contentForSnackbar = "second fragment";
      break;
    case 2:
      contentForSnackbar = "third fragment";
      break;
    }

    fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, contentForSnackbar, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
}