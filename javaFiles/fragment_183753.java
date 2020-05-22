callA(asyncResultA -> {
  System.out.println("Result A: " + asyncResultA.result());

  callB(asyncResultB -> {
    System.out.println("Result B:" + asyncResultB.result());
  });
});