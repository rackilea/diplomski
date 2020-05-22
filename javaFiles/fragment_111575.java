public String[] form(int option)
{
    String[] values = new String[] (5);
    //values[0] = null;  // not necessary since the array elements will already be null
    //values[1] = null;  ...

    ...


    if (result == JOptionPane.OK_OPTION) 
    {
        values[0] = val1Field.getText();
        values[1] = val2Field.getText();
        values[2] = val3Field.getText();
        values[3] = val4Field.getText();
        values[4] = val5Field.getText();

    }

    return values;
}