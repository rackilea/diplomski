public <M extends Message> M newMessage(Class<M> m) { 
    if (m.isAssignableFrom(MyBaseMessage.class)) {
        return (M) new MyBaseMessage();
    }
    if (m.isAssignableFrom(BaseMessage.class)) {
        return (M) new BaseMessage();
    }
    return null;
}