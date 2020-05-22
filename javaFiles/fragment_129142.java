public int compareTo(TestOrder o) {
    if (o.b.contains(a)) 
      return -1;
    else if (b.contains(o.a))
      return 1;
    else
      return a.compareTo(o.a);
}