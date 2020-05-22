private void showTitleProgress(Toolbar t) {
    int pos = t.getComponentCount() - 1; //If you have a command on the left like back command
    //int pos = t.getComponentCount(); //If you don't have a command on the left like back command
    InfiniteProgress ip = new InfiniteProgress();
    ip.setAnimation(YourProgressImage);
    ip.setUIID("icon");
    Container contIp = FlowLayout.encloseCenterMiddle(ip);

    Component.setSameWidth(t.getComponentAt(pos), contIp);
    Component.setSameHeight(t.getComponentAt(pos), contIp);
    t.replaceAndWait(t.getComponentAt(pos), contIp, null);
    t.revalidate();
}

private void hideTitleProgress(Toolbar t, Command cmd) {
    int pos = t.getComponentCount() - 1; //If you have a command on the left like back command
    //int pos = t.getComponentCount(); //If you don't have a command on the left like back command
    Button cmdButton = new Button(cmd.getIcon());
    cmdButton.setUIID("TitleCommand");
    cmdButton.setCommand(cmd);
    t.replaceAndWait(t.getComponentAt(pos), cmdButton, null);
    t.getComponentForm().revalidate();
}