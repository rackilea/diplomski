public void actionPerformed(ActionEvent event) 
{
    if(clickCount > 3)
    {
        button.removeActionListener(this);
    }
    else
        System.out.println("I don't know!");
}