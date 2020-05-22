@Test
public void Test_FindAllPairsIfSumToK(){
    FindAllPairsIfSumToK findAllPairsIfSumToK = new FindAllPairsIfSumToK();
    int[] inputArray1 = {1, 3, 5, 7, 9, 11};
    List<Pair> output1 = findAllPairsIfSumToK.findAllPairsWhoseSumIsK(inputArray1, 10);
    assertEquals (2, output1.size());
    //maybe check if the correct ones are output:
    output1.foreach(p -> assertEquals(10, p.value1 + p.value2));
}