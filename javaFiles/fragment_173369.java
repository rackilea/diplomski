@Test
public void testLetterA() {

    String expected = "A";
    MorseNode<String> actual = p.addLetterToTree();
    assertEquals(p.constructTree(), actual);
}