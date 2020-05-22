hidePasswordCheckbox.addItemListener(new ItemListener() {
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            httpProxyPassword.setEchoChar('*');
        } else {
             httpProxyPassword.setEchoChar((char) 0);
        }
    }
});