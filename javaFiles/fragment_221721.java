StringBuilder stringBuilder = new StringBuilder();
    for (int a =0; a < abc.length(); a++) {
        stringBuilder.append(abc.charAt(a));
        if (a % 2 == 1 && a < abc.length() -1)
            stringBuilder.append(":");
    }