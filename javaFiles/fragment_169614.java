public MainDisplayForm() {
    initComponents();
    ButtonListener_IncreaseGain btnListenerIncreaseGain = new ButtonListener_IncreaseGain();
    btnListenerIncreaseGain.setDisplayForm(....);
    btnListenerIncreaseGain.setStorage(....);
    Btn_IncreaseGain.addActionListener(btnListenerIncreaseGain);
}