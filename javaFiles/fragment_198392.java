@SuppressWarnings("unchecked")
public static void stringRadixSort(List<String> list) {
    List<String>[] buckets = (List<String>[]) Array.newInstance(List.class, 27);

    //Find longest word in list
    int maxWordLength = 0;
    for (String word : list) {
        if (word.length() > maxWordLength) {
            maxWordLength = word.length();
        }
    }

    //Sorts list based on least significant letter (last letter of word) to most significant
    int letterNumber = maxWordLength;
    for (int i = 0; i < maxWordLength; i++) {
        while (!list.isEmpty()) {
            String word = list.remove(list.first());
            int index = 0;
            if(word.length() >= letterNumber) {
                char ch = word.charAt(letterNumber - 1);
                index = ch - 'a' + 1;    //gets index of each letter ('a' = buckets[1], 'z' = buckets[26], buckets[0] is for words shorter than 'letterNumber')
            }
            if (buckets[index] == null) {
                buckets[index] = new LinkedList<String>();
            }
            buckets[index].insertLast(word);
        }

        for (int j = 0; j < buckets.length; j++) {
            if (buckets[j] != null) {
                while (!buckets[j].isEmpty()) {
                    list.insertLast(buckets[j].remove(buckets[j].first()));
                }
            }
        }
        letterNumber--;
    }
}