final int[] count = {0};
map.forEach((key, value) -> {
    if (value == 5)
        count[0]++;
});
System.out.println(count[0]);