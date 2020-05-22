UiApplication.getUiApplication().invokeLater(new Runnable() {
       public void run() {
          int currentIndex = listUsers.getSelectedIndex();
          int scrollPosition = getMainManager().getVerticalScroll();

          //Return vector sze from the handler class
          listUsers.setSize(handler.getItem().size());

          listUsers.setSelectedIndex(currentIndex);
          getMainManager().setVerticalScroll(scrollPosition);
       }
    });