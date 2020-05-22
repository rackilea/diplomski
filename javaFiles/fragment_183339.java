Display display = new Display();
    try {
        Shell shell = new Shell(display);
        try {
            shell.open();
            while (!shell.isDisposed()) {
                if (!display.readAndDispatch()) {
                    display.sleep();
                }
            }
        } finally {
            if (!shell.isDisposed()) {
                shell.dispose();
            }
        }
    } finally {
        display.dispose();
    }
    System.exit(0);