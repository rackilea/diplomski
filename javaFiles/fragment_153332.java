public class MiniExample {
    // the boolean to decide if menu is shown
    private static boolean showMenu = true;

    public static void main(String[] args) {
        Display display = Display.getDefault();
        final Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());

        Tray tray = display.getSystemTray();
        final TrayItem item = new TrayItem(tray, SWT.NONE);

        // INPUT A REAL IMAGE HERE!
        item.setImage(SOME_IMAGE);

        item.addMenuDetectListener(new MenuDetectListener() {

            @Override
            public void menuDetected(MenuDetectEvent event) {
            // if menu shall not be shown, tell it to the event
                if(!showMenu)
                {
                    event.doit = false;
                    return;
                }

            // else create the menu
                Menu menu = new Menu(shell, SWT.POP_UP);
                MenuItem menuitem = new MenuItem(menu, SWT.PUSH);
                menuitem.setText("Do Something");
                menuitem.addListener(SWT.Selection, new Listener() {
                    public void handleEvent(Event e) {
                        System.out.println("Do something!");
                    }
                });

                menu.setVisible(true);
                while (!menu.isDisposed() && menu.isVisible()) {
                    if (!shell.getDisplay().readAndDispatch())
                        shell.getDisplay().sleep();
                }

            // remember to dispose it !!
                menu.dispose();
            }
        });

        Button button = new Button(shell, SWT.PUSH);
        button.setText("Button");
        button.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent arg0) {
                // button decides if menu is shown or not
                showMenu = !showMenu;
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent arg0) {

            }
        });

        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
    }
}