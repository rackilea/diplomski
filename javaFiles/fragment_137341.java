class MyView
{
    public int promptNumber(){
        int num = 0;
        String s = JOptionPane.showInputDialog("Enter a number to test whether it is even or odd.");
        if(s.matches("\\d+"))  //if is numeric
            num = Integer.parseInt(s);
        else
            throw new IllegalArgumentException("Numeric input required.");

        return num;                 
    }

    public void displayResult(String result){
        JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);
    }   
}