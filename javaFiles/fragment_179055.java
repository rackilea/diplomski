private void addMenu(OleFrame frame, String menuName) {
    final Shell shell = frame.getShell();
    Menu menuBar = shell.getMenuBar();
    if (menuBar == null) {
        menuBar = new Menu(shell, SWT.BAR);
        shell.setMenuBar(menuBar);
    }
    MenuItem fileMenu = new MenuItem(menuBar, SWT.CASCADE);
    fileMenu.setText(menuName);
    Menu menuFile = new Menu(fileMenu);
    fileMenu.setMenu(menuFile);
    frame.setFileMenus(new MenuItem[]{fileMenu});

    MenuItem menuFileOpen = new MenuItem(menuFile, SWT.CASCADE);
    menuFileOpen.setText("Save ...");
    menuFileOpen.addSelectionListener(new SelectionAdapter() {
        public void widgetSelected(SelectionEvent e) {
        oleClientSite.save(new File(fileName), true);

        }
    });
    MenuItem menuFileExit = new MenuItem(menuFile, SWT.CASCADE);
    menuFileExit.setText("Quit");
    menuFileExit.addSelectionListener(new SelectionAdapter() {
        shell.dispose();
        }
    });
}

.....
display = new Display();
shell = new Shell(display);
shell.setSize(1000, 700);
shell.setLayout(new FillLayout());

oleFrame = new OleFrame(shell, SWT.NONE);
oleClientSite = new OleClientSite(oleFrame, SWT.NONE, new File(fileName));
oleClientSite.doVerb(OLE.OLEIVERB_INPLACEACTIVATE);

addMenu(oleFrame);