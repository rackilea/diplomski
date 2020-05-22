ViewTreeObserver observer= Button0.getViewTreeObserver();
    observer.addOnGlobalLayoutListener(
            new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {

                    int HighestButton;
                    HighestButton = Button0.getHeight();
                    Log.d("HighestButton", HighestButton+ " 0");
                    if(Button1.getHeight() > HighestButton){
                        HighestButton = Button1.getHeight();
                        Log.d("HighestButton", HighestButton+ " 1");
                    }
                    if(Button2.getHeight() > HighestButton){
                        HighestButton = Button2.getHeight();
                        Log.d("HighestButton", HighestButton+ " 2");
                    }
                    if(Button3.getHeight() > HighestButton){
                        HighestButton = Button3.getHeight();
                        Log.d("HighestButton", HighestButton+ " 3");
                    }

                    Button0.setHeight(HighestButton);
                    Button1.setHeight(HighestButton);
                    Button2.setHeight(HighestButton);
                    Button3.setHeight(HighestButton);

                    if (observer.isAlive()) {
                        observer.removeGlobalOnLayoutListener(this);
                    }

                }
            });