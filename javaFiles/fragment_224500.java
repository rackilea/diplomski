ArrayList <String> matches = new ArrayList <String> ();

        // for each word in dict
        for(String word : sowpodsList) {

            // match flag
            Boolean nonMatch = true;

            // for each character of dict word
            for( char chW : word.toCharArray() ) {

                String w = Character.toString(chW);

                // if the count of chW in word is equal to its count in input, 
                // then, they are match
                if ( word.length() - word.replace(w, "").length() !=
                    input.length() - input.replace(w, "").length() ) {
                    nonMatch = false;
                    break;
                }
            }
            if (nonMatch) {
               matches.add( word );
            }
        }

        System.out.println(matches);