public void startApp() 
        {
            f = new Form("Back Light On");


           d = Display.getDisplay(this);


           start = new Command("Turn On",Command.OK,0);
           stop = new Command("Turn Off",Command.OK,1);

           f.addCommand(start);
           f.setCommandListener(new Action());

    myCanvas = new MyCanvas();
     d.setCurrent(myCanvas);   
            myCanvas.repaint();

}