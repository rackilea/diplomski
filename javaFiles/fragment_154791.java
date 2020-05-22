public abstract class ListenerInformer<T> {
    List<TjbListener<T>> mListeners = new ArrayList<TjbListener<T>>();

    public void addListener(TjbListener<T> u){
        mListeners.add(u);
    }

    public void informAll(T t){
        for(TjbListener<T> u:mListeners){
            u.hearChange(t);
        }
    }
}