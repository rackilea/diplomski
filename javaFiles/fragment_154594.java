public void designMainPanel()
{
    setLayout(null); // if it is null, then nothing shows in the frame
    setSize(650, 520);
    setBounds(0, 0, 650, 520); // ←---- problem is here
    add(getJtpView());
}