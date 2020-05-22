public static boolean isOneSubdomainOfTheOther(String a, String b) {

        try {
            URL first = new URL(a);
            String firstHost = first.getHost();
            firstHost = firstHost.startsWith("www.") ? firstHost.substring(4) : firstHost;

            URL second = new URL(b);
            String secondHost = second.getHost();
            secondHost = secondHost.startsWith("www.") ? secondHost.substring(4) : secondHost;

            /*
             Test if one is a substring of the other
             */           
            if (firstHost.contains(secondHost) || secondHost.contains(firstHost)) {

                String[] firstPieces = firstHost.split("\\.");
                String[] secondPieces = secondHost.split("\\.");

                String[] longerHost = {""};
                String[] shorterHost = {""};

                if (firstPieces.length >= secondPieces.length) {
                    longerHost = firstPieces;
                    shorterHost = secondPieces;
                } else {
                    longerHost = secondPieces;
                    shorterHost = firstPieces;
                }
                //int longLength = longURL.length;
                int minLength = shorterHost.length;
                int i = 1;

                /*
                 Compare from the tail of both host and work backwards
                 */
                while (minLength > 0) {
                    String tail1 = longerHost[longerHost.length - i];
                    String tail2 = shorterHost[shorterHost.length - i];

                    if (tail1.equalsIgnoreCase(tail2)) {
                        //move up one place to the left
                        minLength--;
                    } else {
                        //domains do not match
                        return false;
                    }
                    i++;
                }
                if (minLength == 0) //shorter host exhausted. Is a sub domain
                    return true;
            }
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        }
        return false;
    }