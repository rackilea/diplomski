public void run ()
    {
        //...
        try
        {
            while ( ( len = this.in.read(buffer)) > -1 )
            {
                //...
                SwingUtiltiies.invokeLater(new Runnable() {
                    public void run() {
                        Etiqueta2.setText(data);
                    }
                });
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }            
    }