new Thread(new Runnable() {
            @Override
            public void run() {
                TextMessage message = new TextMessage(input_text.getText().toString(), 0, MainHandler.getUserID(), MainHandler.getUsername());
                MainHandler.sendObject(message);
                input_text.setText("");
            }
        }).start();