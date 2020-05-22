@Override
  public boolean dispatchKeyEvent(KeyEvent event)
  {
          //
          // SEND event.getAction() to your NDK code
          //
          if(<NDK CODE PROCESSED IT>) return true;

          // default behavior for everything else
          return super.dispatchKeyEvent(event);
  }