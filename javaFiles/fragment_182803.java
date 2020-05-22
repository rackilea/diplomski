mContext.getGameView().setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                char pressedKey = (char) event.getUnicodeChar();
                if(event.getAction() == KeyEvent.ACTION_DOWN){
                if(event.getUnicodeChar() == 0){
                    setName.setTitle(removeLastChar(setName.getTitle()));
                } else
                setName.setTitle(setName.getTitle() + (char) event.getUnicodeChar());}
                return false;
            }
        });