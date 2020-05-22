@SuppressWarnings("unchecked");
public <N extends News> void dispatch(N news) {
    Set<Subscriber<?>> subs = subscribersByClass.get(news.getClass());
    if (subs == null)
        return;

    for (Subscriber<?> sub : subs) {
        ((Subscriber<N>) sub).onNews(news);
    }
}