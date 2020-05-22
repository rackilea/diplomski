public static void main(String[] args) throws FileNotFoundException, IOException {

        FileReader fr = new FileReader("\\pathtofile\\data.txt");

        BufferedReader br = new BufferedReader(fr);
        int nextLetter;
        int[] count = new int[26];
        int total = 0;
        int other = 0;

        System.out.println("Letter            Frequency");    
        while ((nextLetter = br.read()) != -1) {
            char current = (char) nextLetter;
            current = Character.toLowerCase(current);
            if (current >= 'a' && current <= 'z') {
                count[current - 'a']++;
                total++;
            } else {
                other++;
            }
        }
        Map ans = sorting(count);  
        printMap(ans);
    }

    private static Map sorting(int[] count) {
        Map m = new LinkedHashMap<String, Integer>() {};
        int k = 0 ;
        for (int i = 0; i < 26; i++) {
             int max =-1;
            for (int j = 0; j < 26; j++) {
                if(max < count[j]){
                    max = count[j];
                    k = j;
                }
            }     
            count[k] = -1;
            if(max!=0)
            m.put(((char)(k+97))+"", max);
            max=0;
        }
        return m;
    }

    public static void printMap(Map<String, Integer> map)
    {
        for (Entry<String, Integer> entry : map.entrySet())
        {
            System.out.println("" + entry.getKey() + "     : "+ entry.getValue());
        }
    }