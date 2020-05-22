int[] nums = {3, -4, 8, 4, -2, 17, 9, -10, 14, 6, -12};
List<Integer> checkPoint1 = new ArrayList<>();
List<Integer> checkPoint2 = new ArrayList<>();
List<Integer> checkPoint3 = new ArrayList<>();
List<Integer> checkPoint4 = new ArrayList<>();
int sum = Arrays.stream(nums)
                .peek(checkPoint1::add)
                .map(n -> Math.abs(n))
                .peek(checkPoint2::add)
                .filter(n -> n % 2 == 0)
                .peek(checkPoint3::add)
                .distinct()
                .peek(checkPoint4::add)
                .sum();
System.out.println(checkPoint1);
System.out.println(checkPoint2);
System.out.println(checkPoint3);
System.out.println(checkPoint4);
System.out.println(sum);