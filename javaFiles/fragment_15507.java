Display display = new Display();
Shell shell = new Shell(display);
shell.setBounds(10,10,200,250);
final Table table = new Table(shell, SWT.NONE);
table.setBounds(10,10,150,200);
table.setLinesVisible(true);
for (int i = 0; i < 5; i++) {
   new TableItem(table, SWT.NONE).setText("item " + i);
}
table.addListener(SWT.MeasureItem, new Listener() {
   public void handleEvent(Event event) {
      int clientWidth = table.getClientArea().width;
      event.height = event.gc.getFontMetrics().getHeight() * 2;
      event.width = clientWidth * 2;
   }
});
shell.open();
while (!shell.isDisposed()) {
   if (!display.readAndDispatch()) display.sleep();
}
display.dispose();