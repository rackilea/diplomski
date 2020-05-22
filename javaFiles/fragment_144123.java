final ViewTreeObserver observer= button.getViewTreeObserver(); //you need an anchor view here that will be drawn via xml
       observer.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //do stuff here.....
    }
});