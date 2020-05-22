boolean updated = false;       //instance variable

    public Class_name()            //would be your constructor or you can put code in initializing method
    {

        TextArea tx = new TextArea();
        Document doc = tx.getDocument();
        doc.addDocumentListener(this);

        internalFrame.addWindowListener(new WindowAdapter()
        {
              public void windowClosing(WindowEvent e)
              {
                    if(updated)
                    {
                        //show dialog box and save changes
                        internalFrame.dispose();
                    }
                    else
                        internalFrame.dispose();
              }
        });
    }   
        after that add use this code in overridden methods
        public void insertUpdate(DocumentEvent e)
        {
             updated = true;
        }
        public void removeUpdate(DocumentEvent e)
        {
             updated = true;
        }
        public void changeUpdate(DocumentEvent e)
        {
             updated = true;
        }