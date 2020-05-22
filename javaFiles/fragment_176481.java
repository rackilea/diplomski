For each char c in original string {
  hash[c]++
}
For each target string str {
  For each char c_ in str {
    if hash[c_] > 0 {
      result++;
    }
  }
}