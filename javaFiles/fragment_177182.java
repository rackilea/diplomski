public T randomPick(Random r) {

        int randomValue = r.nextInt(size());
        int currentSum = 0;
        T lastElement = null;

        for (T t : map.keySet()){
            if (randomValue < currentSum + map.get(t)){
                return t;
            }
            currentSum+= map.get(t);
            lastElement = t;
        }
        return lastElement;
    }