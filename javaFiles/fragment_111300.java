@Override
public void onTextChanged(CharSequence s, int start, int before, int count) 
{   
     if (s.length() > 2) 
     {
         buttonGenerate.setEnabled(true);
     }
     else
    {
         buttonGenerate.setEnabled(true);
    }
}