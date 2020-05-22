final TextField tf1 = new TextField("tf1");
    tf1.setId("tf1");

    final TextField tf2 = new TextField("tf2");
    tf2.setId("tf2");


    ShortcutListener skEnterListener = new ShortcutListener("Enter", ShortcutAction.KeyCode.ENTER, null){

        @Override
        public void handleAction(Object sender, Object target) {

             if (target instanceof TextField) {

                 TextField field = (TextField) target;

                 if ("tf1".equals(field.getId())) {
                     tf2.focus();
                 }

                 if ("tf2".equals(field.getId())) {
                     tf1.focus();
                 }
             }
        }
    };

    addShortcutListener(skEnterListener);