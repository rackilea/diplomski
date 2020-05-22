public void init()
{
    myControl1.addActionListener(new MyActionListener("foo"));
    myControl2.addActionListener(new MyActionListener("bar"));
    myControl3.addActionListener(new MyActionListener("baz"));
}

private class MyActionListener implements ActionListener
{
    private String word;

    public MyActionListener(String word)
    {
        this.word = word;
    }

    public void actionPerformed(ActionEvent e)
    {
        // Handle event
        System.out.println(word);
    }
}