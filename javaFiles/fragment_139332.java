public void executeCallsFire() {
    MyAntTask myTask = Mockito.spy(new MyAntTask());

    myTask.execute();

    Mockito.verify(myTask).fire();
}