@Test
public void testBirds()
{
    final String G = "Grey";
    final String P = "Pink";

    assertTrue(isBirdTypeA(1, 0, G));
    assertFalse(isBirdTypeA(1, 0, P));
    assertTrue(isBirdTypeA(2, 1, G));
    assertTrue(isBirdTypeA(3, 2, G));
    assertTrue(isBirdTypeA(4, 3, G));
    assertTrue(isBirdTypeA(4, 4, G));
    assertTrue(isBirdTypeA(5, 4, G));
    assertFalse(isBirdTypeA(4, 5, G));
    assertFalse(isBirdTypeA(4, 0, G));
    assertFalse(isBirdTypeA(1, 1, G));

}


private static boolean isBirdTypeA(int beak, int claw, String color)
{
    if ("Grey".equals(color)) {
        if ((beak == 1 && claw == 0)
            || (beak == 2 && claw == 1)
            || (beak == 3 && claw == 2)
            || (beak == 4 && claw == 3)
            || ( (beak == 4 || beak == 5) && claw == 4)) {
                return true;
            }
    }
    return false; 
}


public static void main(String[] args) {
  int BEAK_MM = Integer.parseInt(args[0]);
  int CLAW_MM = Integer.parseInt(args[1]);
  String COLOR = args[2];

  if (isBirdTypeA(BEAK_MM, CLAW_MM, COLOR)) {
    System.out.println("The type of bird is A");
  }
}