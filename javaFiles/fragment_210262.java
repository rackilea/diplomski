public Test(String title, String day, String time)
{
    super("Select Seat");
    setSize(350,350);
    setLocation(500,280);
    panel.setLayout(null);
    RectDraw rect= new RectDraw();
    rect.setBounds(0, 0, 100, 100);
    panel.add(rect);

    getContentPane().add(panel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

}