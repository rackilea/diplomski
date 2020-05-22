browser.addVisibilityWindowListener(new VisibilityWindowListener() {
            public void hide(WindowEvent event) {
            }

            public void show(WindowEvent event) {
                Browser browser = (Browser) event.widget;
                Shell shell = browser.getShell();

                if (event.location != null)
                    shell.setLocation(event.location);

                if (event.size != null) {
                    Point size = event.size;
                    shell.setSize(shell.computeSize(size.x, size.y));
                }

                shell.open();
            }
        });