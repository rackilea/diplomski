ShortcutListener skEnterListener = new ShortcutListener("Enter", ShortcutAction.KeyCode.ENTER, null){

        @Override
        public void handleAction(Object sender, Object target) {

            if (target instanceof VerticalLayout) { // VerticalLayout or other
                 // sending fileds here
            }
        }
    };

    addShortcutListener(skEnterListener);