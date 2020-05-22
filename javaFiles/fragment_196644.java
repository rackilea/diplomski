private class ButtonHandler implements ActionListener   //Start of inner class for event handling of buttons
{
        public void actionPerformed( ActionEvent event )
        {//start method that prosesses the events for the buttons

            if(event.getSource() == call)
            {
                //final int elFloor = eCall.calling(); i ran it without this and it worked
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        do{
                        /*There is nothing wrong with calling Thread.sleep directly
                         *wrapping a one liner with your own implementation might cause
                         *more confusion
                         */                     
                        delay.myDelay(2000);

                        //Not sure what is elevatorFloor
                        elevatorFloor = eCall.calling();
                        eCall.setFloor(elevatorFloor);
                        System.out.println("getfloor in call= " +eCall.getFloor()); //Test yields correct value

                        eFloor = ind.level(eCall.getFloor()); //String that gives floor number
                        SwingUtilities.invokeLater(new Runnable(){
                            @Override
                            public void run() {
                                floorIndicator.setText(eFloor); //DOES NOT CHANGE IN GUI
                            }
                        });


                        String value = floorIndicator.getText();
                        System.out.println("Floorindicator is= " +value);//Test yields that the value  is changing dynamically in command line

                        }while(eCall.getFloor() != eCall.getUserFloor());

                        //delay.myDelay(2000);

                        doorImage.setIcon(door1);
                    }
                }).start();
            }
       }
}