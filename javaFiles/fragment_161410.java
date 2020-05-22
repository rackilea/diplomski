try {
   Thread.sleep(20000);
    } catch(InterruptedException ex) {
    System.out.println("caught " + ex.getMessage());
    }

    timer.cancel();

    }