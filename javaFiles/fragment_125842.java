public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
        case R.id.mnuProceessImageAction:
            {
                //Let user know that a background operation is running
                //with a progressbar or something
                processImage(mImage);
                return true;
            }
    }
}

private void processImage(Object image) {
    new Thread(new Runnable(){
        public void run() {
        //Doing all the heavy duty here.
        //.............................
        //Now you have the result. Use it to update the UI.
        //(UI can be updated only from the UI thread)
        runOnUiThread(new Runnable(){
                public void run() {
                    updateTheUiWithTheImage(proccessedImage);
                }
        });
        }
    }).start();

}

private void updateTheUiWithTheImage(Object image) {
    try {
        //Hide progressbar if you have one
        //Now it wont make the UI to struggle to use it.
    } catch(NullPointerException e) {
        e.printStackTrace;
    }
}