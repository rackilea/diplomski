Map<Boolean,Long> result=getBuffers().stream()
    .collect(Collectors.partitioningBy(b -> b.position() > 0, Collectors.counting()));
return
    result.getOrDefault(false, 0L)==0?
        OutgoingMessageStatus.FULLY_SENT:
    result.getOrDefault(true, 0L)==0?
        OutgoingMessageStatus.WAS_NOT_SENT:
        OutgoingMessageStatus.PARTIALLY_SENT;