List<ByteBuffer> buffers = super.getBuffers();
if(buffers.isEmpty()) return OutgoingMessageStatus.FULLY_SENT;
Predicate<ByteBuffer> p = b -> b.position() > 0;
boolean sent = p.test(buffers.get(0));
if(!sent) p = p.negate();
return buffers.stream().skip(1).allMatch(p)? sent?
    OutgoingMessageStatus.FULLY_SENT:
    OutgoingMessageStatus.WAS_NOT_SENT:
    OutgoingMessageStatus.PARTIALLY_SENT;
}