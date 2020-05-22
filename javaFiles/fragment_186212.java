Boolean outBound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

if (!outbound) {
    Long messageId = createId();
    context.put("messageId", messageId);
    saveRequestToDatabase(context.getMessage(), messageId);
} else {
    saveResponseToDatabase(context.getMessage(), context.get("messageId"));
}