String str = "This is a try";
    char[] arr = str.toCharArray();
    char[] temp = new char[arr.length];

    for (int i = 0; i < arr.length; i++) {
        temp[i] = arr[arr.length - 1 - i];
    }