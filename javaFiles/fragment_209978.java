is = new BufferedReader(new InputStreamReader(socket
                    .getInputStream()));

is.mark(5);
char[] tmp = new char[5];
is.read(tmp, 0, 5);

if(new String(tmp).equals("\r\n.\r\n"))
   // you have that message
else
   is.reset();