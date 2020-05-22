for(int i = 0; i < buttons.length; i++){
        for(int j = 0; j < buttons[i].length; j++ ){
            String buttonID = "button" + i + j;
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i][j] = (Button) findViewById(resID);
            buttons[i][j].setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View arg0, MotionEvent arg1) {
                    if (arg1.getAction() == MotionEvent.ACTION_DOWN){
                        socket.emit("button down", getResources().getResourceEntryName(arg0.getId()));
                        return false;
                    }
                    if (arg1.getAction() == MotionEvent.ACTION_UP){
                        socket.emit("button up", getResources().getResourceEntryName(arg0.getId()));
                        return false;
                    }
                    return true;
                }
            });
        }
    }