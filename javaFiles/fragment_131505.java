int[] p = new int[26];
for(int i = 0; i < 26; i++) p[i] = 0;
for (int i = 0; i < notes.size(); i++) {
        String note = notes.get(i);
        for (int j = 0; j < note.length(); j++) {
            char letter = note.charAt(j);
             if(letter>= 'a' && letter <= 'z')
               p[letter-'a']++;

 }