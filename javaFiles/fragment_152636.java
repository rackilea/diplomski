public static void main(String args[]) 
{
    ExampleProgram exampleProgram = new ExampleProgram();
    exampleProgram.exampleClass1.add(new ExampleClass(5,4,3,2,1));
    System.out.println("The example value (which should be 3) is : " + exampleProgram.exampleClass1.get(0).number3);

    java.awt.EventQueue.invokeLater(new Runnable() 
    {
        public void run() 
        {
            new ExampleUI(exampleProgram).setVisible(true);
        }
    });
}