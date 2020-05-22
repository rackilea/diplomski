if (n < 26)
  s += (char)('A' + n); // A-Z is used first
else if (n < 36)
  s += n - 26; // then 0-9
else
  s += ???; // symbols or lower case letters