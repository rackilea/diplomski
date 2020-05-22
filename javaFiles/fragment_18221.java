public void calculator() {
        List<String> marked = new ArrayList<String>();
        try {
            // traverse the whole array
            firstAlphabet = new String[data.length][2]; // set the length of first Alphabet array
            for (int i = 0; i < data.length; i++) {
                String firstLetter = data[i][0].substring(0, 1);
                if(marked.contains(firstLetter)){
                    continue;
                }
                marked.add(firstLetter);
                firstAlphabet[i][0] = firstLetter; // get the first alphabet
                firstAlphabet[i][1] = data[i][1];
                int k = i + 1;
                int v = k;
                int t = 0;
                for (int j = 0; j < data.length - v; j++) {
                    System.out.println("Inner for loop" + j);
                    String s = data[k][0];
                    if (firstAlphabet[i][0].equalsIgnoreCase(s.substring(0,
                            1))) { // line 42
                        System.out.println("If statement");
                        firstAlphabet[i][0] = s.substring(0, 1);
                        Integer z = Integer.parseInt(data[k][1])
                                + Integer.parseInt(firstAlphabet[i][1]);
                        firstAlphabet[i][1] = z.toString();
                    }
                    k++;
                }
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }