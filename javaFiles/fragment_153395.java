final class LazyCombinationsIterator<T> implements Iterator<List<T>> {
    final AtomicInteger idx = new AtomicInteger(0)
    final List<List<T>> lists = []
    final int size
    final List<Integer> listCycle

    LazyCombinationsIterator(List<T>... lists) {
        this.lists.addAll(lists)

        this.size = (int) lists.inject(1) { acc, list -> acc * list.size() }

        this.listCycle = [1] + (lists.inject([]) { List<Integer> acc, list ->
            acc << (acc.isEmpty() ? list.size() : acc.last() * list.size())
        } as List)
    }

    @Override
    boolean hasNext() {
        return idx.get() < size
    }

    @Override
    List<T> next() {
        final int i = idx.getAndIncrement()
        final int to = lists.size()

        return (0..<(to)).collect {
            final List<T> list = lists.get(it)
            final int listIdx = (int) (i / listCycle.get(it))
            return list.get(listIdx % list.size())
        }
    }
}