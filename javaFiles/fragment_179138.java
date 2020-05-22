public static void main(String[] args) {
    performAllTasks(IntStream.range(0, 10)
        .mapToObj(i -> new DebuggableConsumer(""+i)), new Object());
}
private static <T> void performAllTasks(Stream<Consumer<T>> consumerList, T data) {
    Consumer<T> reduced = consumerList.reduce(Consumer::andThen).orElse(x -> {});
    reduced.accept(data);
    System.out.println(reduced);
}
static class DebuggableConsumer implements Consumer<Object> {
    private final Consumer<Object> first, second;
    private final boolean leaf;
    DebuggableConsumer(String name) {
        this(x -> System.out.println(name), x -> {}, true);
    }
    DebuggableConsumer(Consumer<Object> a, Consumer<Object> b, boolean l) {
        first = a; second = b;
        leaf = l;
    }
    public void accept(Object t) {
        first.accept(t);
        second.accept(t);
    }
    @Override public Consumer<Object> andThen(Consumer<? super Object> after) {
        return new DebuggableConsumer(this, after, false);
    }
    public @Override String toString() {
        if(leaf) return first.toString();
        return toString(new StringBuilder(200), 0, 0).toString();
    }
    private StringBuilder toString(StringBuilder sb, int preS, int preEnd) {
        int myHandle = sb.length()-2;
        sb.append(leaf? first: "combined").append('\n');
        if(!leaf) {
            int nPreS=sb.length();
            ((DebuggableConsumer)first).toString(
                sb.append(sb, preS, preEnd).append("\u2502 "), nPreS, sb.length());
            nPreS=sb.length();
            sb.append(sb, preS, preEnd);
            int lastItemHandle=sb.length();
            ((DebuggableConsumer)second).toString(sb.append("  "), nPreS, sb.length());
            sb.setCharAt(lastItemHandle, '\u2514');
        }
        if(myHandle>0) {
            sb.setCharAt(myHandle, '\u251c');
            sb.setCharAt(myHandle+1, '\u2500');
        }
        return sb;
    }
}