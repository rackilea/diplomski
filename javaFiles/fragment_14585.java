final Integer[] sum = new Integer[1];
sum[0] = 0;

myList.forEach(i -> {
    sum[0] = sum[0] + i; // does not compile, sum needs to be final or effectively final
});