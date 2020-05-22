public void createPageControls(Composite pageContainer) {
    if(flag){
        getShell().close();
        return;
    }
    super.createPageControls(pageContainer);
}