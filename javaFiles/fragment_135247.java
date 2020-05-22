@Override
public void afterTextChanged(Editable s)
{    
    if( !s.equalsIngoreCase("smth defined previously"))
         s = "smth defined previously";              
}