String s = data[i-2][j];
byte buf[];
if (s != null) 
    buf = s.getBytes();
else
   buf = //What do you want the default behavior to be? maybe "".getBytes()?