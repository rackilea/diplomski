if (c1 == c2) {
  c3 += c1;
  System.out.println(c3);
  if (c1 != c3) {
    c3 *= c2;
  } else {
    c2 += 5;
    c3 *= c1;
  }
}