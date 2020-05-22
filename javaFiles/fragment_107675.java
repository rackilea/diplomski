Toolkit.getDefaultToolkit().getSystemClipboard().addFlavorListener(
    new FlavorListener() {

    @Override
     public void flavorsChanged(FlavorEvent e) {
         Display.getDefault().asyncExec(new Runnable(){
            public void run(){
              // do things on the UI thread
              String result = "";
              Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
              Transferable contents = clipboard.getContents(null);
              ...
            }
         }
     });