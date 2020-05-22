String hline;
while( (hline = fileReader.readLine()) != null){
     line = hline;
     while( ! hline.endsWith( "}" ) ){
         hline = fileReader.readLine();
         line += hline;
     }