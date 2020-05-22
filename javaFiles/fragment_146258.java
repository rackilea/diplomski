m_submit.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        submit();
        System.out.println("Test");
        butonTest.this.close();
    }
});