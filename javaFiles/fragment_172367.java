public class Solution {
    private static String sortString(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return new ArrayList<>();
        }

        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(Solution::sortString))
                .values());
    }
}