public static void main(String[] args) {
    char[][] arr = {
            {'a', 'b', 'c', 'd', 'e', 'q'},
            {'f', 'g', 'h', 'i', 'j', 'w'},
            {'k', 'l', 'm', 'n', 'o', 'e'},
            {'p', 'q', 'r', 's', 't', 'r'},
            {'u', 'v', 'w', 'x', 'z', 't'}};

    for (char[] diag : diagonal(arr))
        System.out.println(diag);
}