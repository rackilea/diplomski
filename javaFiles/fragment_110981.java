java.awt.Window win[] = java.awt.Window.getWindows();   
    for(int i=0;i<win.length;i++){   
        if (win[i].getName().equals("YourWindowName"))
          isOpen = true;
          break; 
    }