Scanner s = new Scanner(System.in);
        ArrayList<Double> ratios=new ArrayList<Double>();
        ArrayList<String> sentences=new ArrayList<String>();

        System.out.println("Enter a line of text: ");
        while (s.hasNextLine()) {
            String sentence = s.nextLine();
            // Get the number of white spaces
            int count = 0;
            for(int i = 0; i < sentence.length(); i++) {
                if(Character.isWhitespace(sentence.charAt(i))) count++;
            }
            //number of Characters
            int totchars = sentence.length()-count;
            //Add the ratio to our ArrayList
            ratios.add((double) count / totchars);
            // Add the Sentence to ArrayList
            sentences.add(sentence);
            if (sentence.length()==0) {
                break;
            }

        }
        //Find The best Ratio
        int best=0;
        for(int i=0;i<ratios.size();i++) {
            if(ratios.get(i)<ratios.get((int)best))
                best=i;
        }
        System.out.println("Best line so far is: " + sentences.get((int)best));

    }