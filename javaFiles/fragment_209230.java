Button resize = new Button(shell, SWT.PUSH);
resize.setText("Resize");
resize.setBounds(140, 430, 20, 20);
resize.addListener(SWT.Selection, new Listener() {
    public void handleEvent(Event e) {
        if (!isMaximized) {
            Region region = new Region();
            region.add(circle(20, 20, 20));
            region.add(circle(20, 20, 580));
            region.add(circle(20, 280, 20));
            region.add(circle(20, 280, 580));
            region.add(new int[] { 20, 0, 280, 0, 280, 600, 20, 600 });
            region.add(new int[] { 0, 20, 300, 20, 300, 580, 0, 580 });
            shell.setRegion(region);
            Rectangle size = region.getBounds();
            shell.setSize(size.width, size.height);
            resize.setBounds(140, 580, 20, 20);
            isMaximized = true;
        }else {
            Region region = new Region();
            region.add(circle(20, 20, 20));
            region.add(circle(20, 20, 430));
            region.add(circle(20, 280, 20));
            region.add(circle(20, 280, 430));
            region.add(new int[] { 20, 0, 280, 0, 280, 450, 20, 450 });
            region.add(new int[] { 0, 20, 300, 20, 300, 430, 0, 430 });
            shell.setRegion(region);
            Rectangle size = region.getBounds();
            shell.setSize(size.width, size.height);
            resize.setBounds(140, 430, 20, 20);
            isMaximized = false;
        }
    }
});