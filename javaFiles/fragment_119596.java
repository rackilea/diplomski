String[] split = q.toString().split("\\s");
Map<String, Integer> terms = new HashMap<String, Integer>();

for (String term : split) {
    int score = 0;
    if(terms.containsKey(term)){
        score = terms.get(term);
    }

    terms.put(term, score +1);
}