public void update() {
  double now = (double)System.currentTimeMillis();
  double per;
  if (st >= et || now >= et) {
System.out.println ("st: " + st + ", et: " + et);
System.out.println(100);
    return;
  }
  if (now <= st) {
System.out.println(000);
    return;
  }
  per = (now - st) * 100.0 / (et - st);
  System.out.println(per);
}