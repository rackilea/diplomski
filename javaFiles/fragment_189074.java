Set<String> usernames = new HashSet<>();
while (listScanner.hasNextLine()) {
     usernames.add( listScanner.nextLine() );
}

while (dictScanner.hasNextLine()) {
     String curr = dictScanner.nextLine();
     if( usernames.contains( curr ){
         System.out.println( curr );
     }
}