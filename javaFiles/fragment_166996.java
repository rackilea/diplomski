public List<Integer> maxValue(int array[]){
        int max = Arrays.stream(array).max().orElse(-1);
        return IntStream.range(0, array.length)
                        .filter(idx -> array[idx] == max)
                        .mapToObj(i -> i)
                        .collect(Collectors.toList());
}