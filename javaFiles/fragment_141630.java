public class LoadButtonHandler implements ActionListener 
{
    private int number;

    public LoadButtonHandler(int number){
      this.number=number;
    }

    public void actionPerformed (ActionEvent ae)  

    {
        System.out.println(number); // and outputting it here.. Everything else works so far
    }
}