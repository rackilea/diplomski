private void createUI(Shell shell) {
    Composite bgcontainer = new Composite(shell, SWT.NONE); // new
    [...]
    Composite container = new Composite(bgcontainer, SWT.NONE);
    [...]
    fBar = new ProgressBar(container, SWT.HORIZONTAL);
    [...]
    Label versionLabel = new Label(container, SWT.NONE);
    versionLabel.setLayoutData(new GridData(SWT.END, SWT.BEGINNING, true, false));
    shell.layout(true, true);
}   

@Override public IProgressMonitor getBundleProgressMonitor() {
return new NullProgressMonitor() {
    @Override public void beginTask(String name, final int totalWork) {
        getSplash().getDisplay().syncExec(new Runnable() {
            public void run() {
                    if (fBar != null) fBar.setSelection(40);
                    Image image = fImageList.get(imageIdx++);
                    bgcontainer.setBackgroundImage(image);
                    bgcontainer.setRedraw(true);
                    bgcontainer.update();                 
                }
            });
        }

    @Override public void subTask(String name) {
        final String n = name;
        getSplash().getDisplay().syncExec(new Runnable() {
            String taskname = n;
            public void run() {
                    if (fBar != null && fBar.getSelection() < 100)
                        fBar.setSelection(fBar.getSelection() + 10);
                    if (fBar.getSelection() == 60 || fBar.getSelection() == 80) {
                        if (imageIdx >= fImageList.size()) imageIdx = 0;
                        Image image = fImageList.get(imageIdx++);
                        bgcontainer.setBackgroundImage(image);
                        bgcontainer.setRedraw(true);
                        bgcontainer.update();
                    }
                 }
             });
         }
    };
}