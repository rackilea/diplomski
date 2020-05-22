private static void permute(String acc, String str,Set<Integer> result,int z) {
    int n = str.length();
    if (acc.length() == z)
        result.add(Integer.parseInt(acc));
    else {
        for (int i = 0; i < n; i++)
            permute(acc + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), result, z);

    }
}

System.out.println(maxDigit("1234", 2)); 
43