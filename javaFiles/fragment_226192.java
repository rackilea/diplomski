package org.openqa.selenium;

    public enum UnexpectedAlertBehaviour {

      ACCEPT ("accept"),
      DISMISS ("dismiss"),
      IGNORE ("ignore")
      ;

      private String text;

      private UnexpectedAlertBehaviour(String text) {
        this.text = text;
      }

      @Override
      public String toString() {
        return String.valueOf(text);
      }

      public static UnexpectedAlertBehaviour fromString(String text) {
        if (text != null) {
          for (UnexpectedAlertBehaviour b : UnexpectedAlertBehaviour.values()) {
            if (text.equalsIgnoreCase(b.text)) {
              return b;
            }
          }
        }
        return null;
      }
    }