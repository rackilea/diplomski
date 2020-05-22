for(int j=(i+1); j< words.size(); j++) {
    if (isAnagram(words.get(i), words.get(j))){
        result.add(words.get(i) + " " + words.get(j));
        System.out.println(result);
        words.remove(j);
    }
}