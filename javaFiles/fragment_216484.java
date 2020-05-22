Button b = new Button(""+n);
b.addActionListener(new ActionListener() {

    public void actionPerformed(ActionEvent e)
    {
        System.out.println("You clicked button "+e.getSource().toString());
    }
});

this.add(b);