}catch(NumberFormatException e) {
    frame.setVisible(false); //<-- This bit
    poop += " " + s.next(); 
    if(poop.equals("you lose")) new ResultDisplay("green");
    handler.hb2.resultDisplayed = true;
    stop();
}