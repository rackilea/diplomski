for (x = 0; x < 8; x++) {
                if (searchcrime.compareTo(crime[x])==0) {
                    if (!found) { // print title before first match
                        System.out.println(" Name " + " -----" + " Crime " + "-----" + " Year ");
                    }          
                    System.out.println( name[x] + " --- " + crime[x] + " --- " + year[x]);
                    found = true;
                }
            }
            if (!found) {
                System.out.print("Error! Crime not found");
            }