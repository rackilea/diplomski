static String[] words = { "Cowboy", "animal", "monster" };
    static String s = "My animal is a Cowboy";
    static boolean check = false;
    static String[] meanings = {"meaning1", "meaning2", "meaning3"};
    static ArrayList<String> typed_words = new ArrayList<String>();
    static ArrayList<String> typed_meanings = new ArrayList<String>();


        for (int i = 0; i < words.length; i++) {
            if (s.toLowerCase().contains(words[i].toLowerCase())) {

                typed_words.add(words[i]);
                typed_meanings.add(meanings[i]);
                check = true;

            } else {

            }

        }

        if (check) {
            System.out.println("Yes");
            for(int i=0;i<typed_words.size();i++){
                System.out.println("Word: "+typed_words.get(i)+" Meaning: "+typed_meanings.get(i));
            }

        } else {
            System.out.println("No");
        }