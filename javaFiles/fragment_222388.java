try {
        line = (TargetDataLine) AudioSystem.getLine(info);
        line.open(Player.format);
        line.start();

    } catch (LineUnavailableException ex) {
        // Handle the error ... 
    }