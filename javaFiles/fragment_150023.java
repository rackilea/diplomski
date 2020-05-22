class ProxyingIterator implements Iterator<CharSequence> {

    List<CharSequence> slowList;
    int pos = 0;

    public ProxyingIterator(List<CharSequence> slowList) {
        this.slowList = slowList;
    }

    @Override
    public boolean hasNext() {
        return pos < slowList.size();
    }

    @Override
    public CharSequence next() {
        return (CharSequence) Proxy.newProxyInstance(
                        CharSequence.class.getClassLoader(),
                        new Class[] { CharSequence.class },
                        new LazyLoadingInvocationHandler(pos++));
    }

    private class LazyLoadingInvocationHandler implements InvocationHandler {

        int index;
        CharSequence loadedObject = null;

        public LazyLoadingInvocationHandler(int index) {
            this.index = index;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) {
            if (loadedObject == null)
                loadedObject = slowList.get(index);
            try {
                return method.invoke(loadedObject, args);
            } catch (Exception shouldNotHappen) {
                shouldNotHappen.printStackTrace();
                return null;
            }
        }
    }
}