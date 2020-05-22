public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("Stackoverflow");
    shell.setLayout(new FillLayout());

    Label label = new Label(shell, SWT.NONE);

    DropTarget target = new DropTarget(label, DND.DROP_DEFAULT | DND.DROP_MOVE | DND.DROP_COPY);

    Transfer[] transfers = new Transfer[]{FileTransfer.getInstance()};

    target.setTransfer(transfers);
    target.addDropListener(new DropTargetAdapter()
    {
        public void drop(DropTargetEvent event)
        {
            if (event.data == null)
            {
                event.detail = DND.DROP_NONE;
                return;
            }

            String[] paths = (String[]) event.data;
            List<File> files = new ArrayList<>();

            for (String path : paths)
            {
                int index = path.lastIndexOf(".");
                if (index != -1)
                {
                    String extension = path.substring(index + 1);
                    if (Objects.equals(extension, "svg"))
                        files.add(new File(path));
                }
            }

            System.out.println(files);
        }
    });

    shell.pack();
    shell.open();
    shell.setSize(400, 300);

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}