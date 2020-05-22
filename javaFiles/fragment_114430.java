if (audioplay != null) {
        bg.Terminate();
        playplayer.close();
    try {
        audioplay.join();
    } catch (InterruptedException ex) {
        //catch the exception
    }
        System.out.print("The thread has stopped");
    }