class ParentClass extends JPanel implements ActionListener
{
   ParentClass()
   {
       JButton button = new JButton("something");
       button.addActionListener(this);
       add(button);
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        System.out.println("I am the parent.");
    }
}

class SubClass extends ParentClass
{
    SubClass()
    {
       super();//initialize button
    }

     @Override
     public void actionPerformed(ActionEvent event)
     {
         System.out.println("I am the child.");
     }
}