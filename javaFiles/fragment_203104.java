@Then("the result will be $expected)
public void then1(List<Integer> result) {
    assertEquals(estimator.getResult(), result);
}

....

@Then("the result will be $expected)
public void then1(List<Integer> result) {
    assertEquals(estimator.getResult(), result);
}