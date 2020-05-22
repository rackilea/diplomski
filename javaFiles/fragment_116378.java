@Test
public void testSequential() throws Exception {
    int sum = 0;
    for (int i = 0; i < NUM_TASKS; i++) {
        sum += this.task();
    }

    Assert.assertEquals(NUM_TASKS, sum);
}