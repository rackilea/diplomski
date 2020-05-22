private void notifyMessageListeners(Message message, ValueGetter<T> getter) {
    LinkedList<IRequestListener<?>> listeners = 
         requestListenerMap.get(message.getType());

    for (IRequestListener<?> listener : listeners) {
        IRequestListener<T> notificationListener = 
            (IRequestListener<T>) listener;
        notificationListener.resultUpdated(getter.getValue(message.getData()));
     }
}