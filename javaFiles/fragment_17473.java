String[] xs = { "a", "a", "b", "c", "c" };

    Set<String> singles = new TreeSet<>();
    Set<String> multiples = new TreeSet<>();

    for (String x : xs) {
        if(!multiples.contains(x)){
            if(singles.contains(x)){
                singles.remove(x);
                multiples.add(x);
            }else{
                singles.add(x);
            }
        }
    }