public class MyProcessor implements
    ItemProcessor<YourItem, YourItem> {
    @Override
    public YourItem process(YourItem arg0) throws Exception {
    // Apply any logic to your Item before transferring it to the writer
    return arg0;
    }
    }