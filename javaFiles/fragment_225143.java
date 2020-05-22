String foo() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 100; i++)
       sb.append(i);
    return sb.toString();
}