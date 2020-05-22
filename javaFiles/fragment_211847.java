shell.addShellListener(new ShellAdapter() {
        @Override
        public void shellClosed(ShellEvent e) {

                Field f = Display.class.getDeclaredField("captureChanged");
                f.setAccessible(true);
                System.out.println("captureChanged = " + f.get(e.display)); //true = If User triggered the Event
                System.out.println("closed");
        }
    });