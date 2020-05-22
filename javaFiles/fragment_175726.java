addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent windowEvent)
            {
               // here your logic to save the data
                System.out.println("Window is being Closed");
                windowEvent.getWindow().dispose();
            }
        });