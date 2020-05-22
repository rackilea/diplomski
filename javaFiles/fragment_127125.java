inputBox.addKeyPressHandler(new KeyPressHandler() {
                public void onKeyPress(KeyPressEvent event) {
            // TODO Auto-generated method stub
            System.out.println(event.getUnicodeCharCode());

            if(event.getUnicodeCharCode() == 64){
            item.add(box);
            }
        }
    });