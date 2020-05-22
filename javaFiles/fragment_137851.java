class Anagram {

    private  boolean isAnagram(String s1, String s2) {
        s1=s1.replaceAll("\\s+","");
        s2=s2.replaceAll("\\s+","");
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> anagramMap = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ++ch) 
             anagramMap.put(ch, 0); 
        for(int i=0; i<s1.length(); i++){
            anagramMap.put(s1.charAt(i), anagramMap.get(s1.charAt(i))+1);
        }
        for(int j=0; j<s2.length(); j++) {
            if (anagramMap.get(s2.charAt(j)) != 0) {
                anagramMap.put(s2.charAt(j), anagramMap.get(s2.charAt(j)) - 1);
            }
        }
        for(int value : anagramMap.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
    private void solveChallenge(List<String> words) {
        List<String> result = new ArrayList<>();
        for(int i=0 ;i<(words.size()); i++) {
            List<String> resultant_strings=new ArrayList<> ();
            resultant_strings.add(words.get(i));

            for(int j=(i+1); j< words.size(); j++) {
                if (isAnagram(words.get(i), words.get(j))){
                    resultant_strings.add(words.get(j));
                    words.remove(j);
                    j--;
                }
            }
            Collections.sort(resultant_strings);
            String resultant_string=resultant_strings.toString();
            result.add(resultant_string);
        }
        Collections.sort(result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        List<String> words = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String line = reader.readLine();
            Integer numTestCases = Integer.parseInt(line);
            while (--numTestCases >= 0){
                words.add(reader.readLine().toLowerCase());
            }
            System.out.println(words);
            new Anagram().solveChallenge(words);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}