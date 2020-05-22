else if(e.getSource()==SButtonList[4])//checks if it's equal sign
              {
                  for(int i =0;i<10;i++)
                  {
                  if(name.getText().length()>0) //make sure this string isn't empty
                    result[i] = Double.parseDouble(name.getText().substring(1));