while(isHappy()){ // your logic goes here.
    do {

        do {

            g = (Graphics2D) strategy.getDrawGraphics();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 500, 500);
            g.setColor(Color.red);
            g.fillRect(10, 40, 50, 70);
            g.dispose();


        }while(strategy.contentsRestored());
        strategy.show();

    }while(strategy.contentsLost());
}