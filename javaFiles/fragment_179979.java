public class TestSo {
    @Test
    public void testSo() {
        AImpl.create().choice(
                new ChoiceList()
                        .add(AChoice.create().execute())
                        .add(AChoice.create().choice(
                                new ChoiceList().add(AChoice.create())
                        ))
                        .add(AChoice.create().execute().choice(
                                new ChoiceList()
                                        .add(AChoice.create())
                                        .add(AChoice.create())
                        ))
        );
    }
}