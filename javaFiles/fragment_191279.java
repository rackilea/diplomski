public static String highAndLow(String numbers) {
        List<Integer> nums = Arrays.asList(numbers.split(" ")).stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());
        int max = nums.stream().reduce((a, b) -> a > b ? a : b).orElse(0);
        int min = nums.stream().reduce((a, b) -> a < b ? a : b).orElse(0);
        return max + " " + min;
}