public String next() {
    int from = given.length() - this.index - 1;
    int to = given.length() - this.index;
    String answer = this.given.substring(from, to);
    this.index = index + 1;
    return answer;
}