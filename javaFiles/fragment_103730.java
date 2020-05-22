String str = "ABC";
    int n = str.length();
    ArrayList<String> list = new ArrayList<>();
    permute(str, 0, n-1, list);

    System.out.println(list.size());