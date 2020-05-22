double b = 0;
try
{
  b = Double.parseDouble(textField.getText().toString());     
}
catch(NumberFormatException e)
{
  System.out.println("Invalid number!");
}
ArrayList<Double> myVector=new ArrayList<Double>(); 
myVector.add(b);