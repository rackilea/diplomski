if (!Control.model.twoCardsTurned)
    {
        if ("unturn".equals(action)) 
        {
            new Timer(1000, new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    keypadArray[pos].setIcon(back);
                    keypadArray[Control.model.lastCard].setIcon(back);
                    System.out.println("Card: "+pos+" unset");
                    System.out.println("Card: "+Control.model.lastCard+" unset");
                }
            }).start();
        }
    }