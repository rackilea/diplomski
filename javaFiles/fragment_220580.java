BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
char[] a = new char[1000];
int line;
String responseLine, server_response = "";
for(int i = 0; i < a.length; i++){ //
      a[i] = ' ';                  // this is the for loop i added
    }                              //
while((line = in.read(a)) != -1) {
      responseLine = String.valueOf(a);
      server_response = server_response + responseLine;
      for(int i = 0; i < a.length; i++){ //
          a[i] = ' ';                    // this is the for loop i added
        }                                //
     }
in.close();
return server_response.trim();     // this is where i return the response trimmed