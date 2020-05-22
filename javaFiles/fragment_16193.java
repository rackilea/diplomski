@Test
public void testIsBalanced() {
    assertTrue(isBalanced("(2)"));
    assertTrue(isBalanced("(2+3+3)"));
    assertTrue(isBalanced("2+3+3"));
    assertTrue(isBalanced("2+(4|5|5)+3"));
    assertTrue(isBalanced("2+(4|(2+3+4)|5)+3"));
    assertTrue(isBalanced("(2)+3()"));
    assertFalse(isBalanced("(2"));
    assertFalse(isBalanced("(2))"));
    assertFalse(isBalanced("((2)"));
    assertFalse(isBalanced("2|3+3"));
    assertFalse(isBalanced("2+(4|5+5)+3"));
    assertFalse(isBalanced("2+3|3"));
}