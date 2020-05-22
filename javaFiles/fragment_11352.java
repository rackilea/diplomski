public static void main(String[] args) throws Exception
  {
    // Get a reference to the clipboard
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    // Poll once per second for a minute
    for (int i = 0; i < 60; i++)
    {
      // Null is ok, because, according to the javadoc, the parameter is not currently used
      Transferable transferable = clipboard.getContents(null);

      // Ensure that the current contents can be expressed as a String
      if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor))
      {
        // Get clipboard contents and cast to String
        String data = (String) transferable.getTransferData(DataFlavor.stringFlavor);

        if (data.equals("Hello"))
        {
          // Change the contents of the clipboard
          StringSelection selection = new StringSelection("Test");
          clipboard.setContents(selection, selection);
        }
      }

      // Wait for a second before the next poll
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        // no-op
      }
    }
  }