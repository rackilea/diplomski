EventHandler eh = (EventHandler<KeyEvent>) event -> {
      Spinner sp = (Spinner) event.getSource();
      switch (event.getCode()) {
          case UP:
              sp.increment(1);
              break;
          case DOWN:
              sp.decrement(1);
              break;
          default:
      }
  };

 spinner1.getEditor().setOnKeyPressed(eh);
 spinner2.getEditor().setOnKeyPressed(eh);