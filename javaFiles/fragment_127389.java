public class ProtobufEncoder extends MessageToMessageEncoder<MessageLiteOrBuilder> {
    public ProtobufEncoder() {
    }

    protected void encode(ChannelHandlerContext ctx, MessageLiteOrBuilder msg, List<Object> out) throws Exception {
        if (msg instanceof MessageLite) {
            out.add(Unpooled.wrappedBuffer(((MessageLite)msg).toByteArray()));
        } else {
            if (msg instanceof Builder) {
                out.add(Unpooled.wrappedBuffer(((Builder)msg).build().toByteArray()));
            }

        }
    }
}