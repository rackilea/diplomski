public class MainPane 
{
    public void displayGUI()
    {
        ....
        p1 = new Firstcard1(contentPane);
        p2 = new SecondCard1(contentPane);

        p1.setSecondCard(p2);
        ....
    }
}