public class YourPage {

    @Inject private Block blockA;
    @Inject private Block blockB;
    @Inject private Block blockC;

    public Object getBlockToRender() {
        Block blockToRender;
        // logic here to set blockToRender to blockA, blockB or blockC
        return blockToRender
    }
}