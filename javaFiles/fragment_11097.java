EditText ed = (EditText) findViewById(R.id.inputFrequency);


Spinner spinner = (Spinner)findViewById(R.id.dropdown);
String text = spinner.getSelectedItem().toString();


int count = 0;
while(count < countryList.length)
{
    if((countryList[count]).getName().equals(text))
    {
        try
        {
            countryList[count].setFrequency(Integer.parseInt(ed.toString()));
        }
        catch(NumberFormatException e)
        {
            countryList[count].setFrequency(0);
        }
    }
    count++;
}