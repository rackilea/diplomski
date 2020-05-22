private static void appendRange(StringBuilder sb, int begin, int end) {
    sb.append(",").append(begin);
    if (end != begin)
        sb.append("-").append(end);
}

public static String sequenceNums(int[] nums) {
    StringBuilder sb = new StringBuilder();
    if (nums.length == 0) return sb.toString();
    int begin = nums[0], end = nums[0];
    for (int cur : nums)
        if (cur - end <= 1)
            end = cur;
        else {
            appendRange(sb, begin, end);
            begin = end = cur;
        }
    appendRange(sb, begin, end);
    return sb.substring(1);
}

@Test
public void testSequenceNums() {
    assertEquals("1-5,9,13-15", sequenceNums(new int[] {1, 2, 3, 4, 5, 9, 13, 14, 15}));
    assertEquals("4,6,8,10-12,15,17", sequenceNums(new int[] {4, 6, 8, 10, 11, 12, 15, 17}));
    assertEquals("1-7", sequenceNums(new int[] {1, 2, 3, 4, 5, 6, 7}));
    assertEquals("", sequenceNums(new int[] {}));
}