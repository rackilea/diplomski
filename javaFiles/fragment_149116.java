public void createPartControl(Composite parent) {

    FileDialog dlg = new FileDialog(parent.getShell(), SWT.OPEN);
    String fileName = dlg.open();
    if (fileName != null) {
        System.out.println(fileName);
    }
}