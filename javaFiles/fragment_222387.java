try {
        line = (TargetDataLine) AudioSystem.getLine(info);
        line.start();
        line.open(Player.format);

    } catch (LineUnavailableException ex) {
        // Handle the error ... 
    }