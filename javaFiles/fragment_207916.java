public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,10);
        map.put(2,100);
        map.put(3,20);
        map.put(4,990);

        Map.Entry<Integer, Integer> integerIntegerEntry = map.entrySet()
                .stream().min(Comparator.comparing(Map.Entry::getKey))
                .orElseThrow(() ->new RuntimeException("Oops!"));
        System.out.println("min val is :" + integerIntegerEntry.getValue());
        anotherMethod(integerIntegerEntry.getKey());
    }