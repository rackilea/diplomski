public String fixNoun(String noun) { 
    String determinenet= noun.substring(noun.length() - 1);

       if(determinenet.equals("a")) {
          return("la" + " "+noun );
       }
       else if ( determinenet.equals("o")) {
          return( "el"+ " "+noun);
       }
       else {
           return("?"+ " "+noun);
       }
    } 
}