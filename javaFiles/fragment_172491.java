if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
        x += Clock.delta() * speed;
    }  
    if (Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
        y += Clock.delta() * speed;
    }  
    if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
        x -= Clock.delta() * speed;
    } 
    if (Keyboard.isKeyDown(Keyboard.KEY_UP)){
        y -= Clock.delta() * speed;
    }