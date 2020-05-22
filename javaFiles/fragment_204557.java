public String toString() {
    StringBuilder builder = new StringBuilder();
    for (int num = 1; num < max; num++) { . // used to start at 2
        if (numbers[num]) {
            builder.append(num+1).append(" ");
        }
    }
    return builder.toString();
    }
}