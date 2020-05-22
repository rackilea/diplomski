// Get the reference to UI to be modified
        final UI ui = getUI();

        new Thread() {
            @Override
            public void run() {
                // Do stuff that don't affect UI state here, e.g. potentially
                // slow calculation or rest call
                final double d = 1*1;

                ui.access(new Runnable() {
                    @Override
                    public void run() {
                        // This code here is safe to modify ui
                        Notification.show("The result of calculation is " + d);
                    }
                });
            }
       }.start();