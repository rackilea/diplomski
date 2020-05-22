if(name.equals("empty")){
        load.setCharacter(space);
    }else if(name.equals("fTurnUp")){
        load.setCharacter(space);
        move = false;
        moveUp();
    }else if(name.equals("fTurnDown")){
        load.setCharacter(space);
        move = false;
        moveDown();
    }else if(name.equals("fTurnLeft")){
        load.setCharacter(space);
        move = false;
        moveLeft();
    }else if(name.equals("fTurnRight")){
        load.setCharacter(space);
        move = false;
        moveRight();
    }else if(name.equals("turn")){
        load.setCharacter(space);
        move = false;
    }else if(name.equals("finish")){
        load.setCharacter(space);
        move = false;
        Component frame = null;
        JOptionPane.showMessageDialog(frame,
                "Congratulations! You have completed the level.",
                "Level Completed",
                JOptionPane.PLAIN_MESSAGE);
    }else if(name.equals("wall")){
        move = false;
        Component frame = null;
        JOptionPane.showMessageDialog(frame,
                "The level was not designed correctly. Click 'Ok' to return to main menu",
                "Invalid Level",
                JOptionPane.ERROR_MESSAGE);
    }