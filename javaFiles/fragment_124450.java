String mostRepeatedWord = null;
int count = 0;
for (Map.Entry < String, Integer > m: map.entrySet()) {
    if (m.getValue() > count) {
        mostRepeatedWord = m.getKey();
        count = m.getValue();
    } else if (m.getValue() == count) {
        String key = m.getKey();
        if ( key.compareTo(mostRepeatedWord) ) < 0 {
            mostRepeatedWord = key;
        }
    }
}