package SO37060005;

public class LoopStyle {
  int q, i, r, charPos, digits[], buf[];

  public void loop1() {
    for (;;) {
      q = (i * 52429) >>> (16 + 3);
      r = i - ((q << 3) + (q << 1));  // r = i-(q*10) ...
      buf[--charPos] = digits[r];
      i = q;
      if (i == 0) {
        break;
      }
    }
  }

  public void loop2() {
    do {
      q = (i * 52429) >>> (16 + 3);
      r = i - ((q << 3) + (q << 1));  // r = i-(q*10) ...
      buf[--charPos] = digits[r];
      i = q;
    } while (i != 0);
  }
}