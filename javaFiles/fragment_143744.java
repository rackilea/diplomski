import static test.NettySplit.insertString;

public class NettySplitTest {

    CompositeByteBuf buffer;
    ByteBuf test;

    private void addByteBuf(CompositeByteBuf target, ByteBuf source) {
        target.addComponent(source);
        target.writerIndex(target.writerIndex() + source.readableBytes());
    }

    @Before
    public void before() {
        buffer = ByteBufAllocator.DEFAULT.compositeBuffer();
    }

    @After
    public void after() {
        ReferenceCountUtil.release(buffer);
        buffer = null;
        ReferenceCountUtil.release(test);
        test = null;
    }

    @Test
    public void testSplitting() {
        addByteBuf(buffer, Unpooled.wrappedBuffer(new byte[]{0, 1, 2, 3}));

        insertString(buffer, 2, Unpooled.wrappedBuffer(new byte[]{5}));

        test = Unpooled.wrappedBuffer(new byte[]{0, 1, 5, 2, 3});
        assertEquals(test, buffer);

    }

    @Test
    public void testInsertionStart() {
        addByteBuf(buffer, Unpooled.wrappedBuffer(new byte[]{0, 1, 2, 3}));

        insertString(buffer, 0, Unpooled.wrappedBuffer(new byte[]{5}));

        test = Unpooled.wrappedBuffer(new byte[]{5, 0, 1, 2, 3});
        assertEquals(test, buffer);
    }

    @Test
    public void testInsertionEnd() {
        addByteBuf(buffer, Unpooled.wrappedBuffer(new byte[]{0, 1, 2, 3}));

        insertString(buffer, 4, Unpooled.wrappedBuffer(new byte[]{5}));

        test = Unpooled.wrappedBuffer(new byte[]{0, 1, 2, 3, 5});
        assertEquals(test, buffer);
    }

    @Test
    public void testInsertionSplitEnd() {
        addByteBuf(buffer, Unpooled.wrappedBuffer(new byte[]{0, 1, 2, 3}));
        addByteBuf(buffer, Unpooled.wrappedBuffer(new byte[]{0, 1, 2, 3}));

        insertString(buffer, 6, Unpooled.wrappedBuffer(new byte[]{5}));

        test = Unpooled.wrappedBuffer(new byte[]{0, 1, 2, 3, 0, 1, 5, 2, 3});
        assertEquals(test, buffer);
    }

}