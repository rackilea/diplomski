if (inData.equals("c"))
{
    System.out.println("Enter a value.");
    inData = stdin.readLine ( );
    c = Integer.parseInt (inData);
    Celsius cel = new Celsius();
    cel.setValue(c);
    System.out.println("The converted value is: " + c.getConvertedValue());
}