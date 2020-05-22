public static void main(String[] args) {
    String str = "xyzxyzxyzxyz";
    Map<Character, Integer> map = new HashMap<>();
    for (char c : str.toCharArray())
    {
        Integer count = map.get(c);
        if (count == null)
            count = 0;
        map.put(c, count + 1);
    }
    int sum = 0;
    for (int n : map.values())
        sum += ((n - 1) * n) / 2;
    System.out.println(sum);
}