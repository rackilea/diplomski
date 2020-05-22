public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();
    map.put("a", 1);
    map.put("b", 2);

    for(int depth: new int[] { 1, 2, Integer.MAX_VALUE }) {
        System.out.println("With max depth: "+depth);
        Tree<Spliterator<Map.Entry<String, Integer>>> spTree
            = split(map.entrySet().spliterator(), depth);
        Tree<String> valueTree = spTree.map(sp -> "estimated: "+sp.estimateSize()+" "
            +StreamSupport.stream(sp, false).collect(Collectors.toList()));
        System.out.println(valueTree);
    }
}

private static <T> Tree<Spliterator<T>> split(Spliterator<T> sp, int depth) {
    Spliterator<T> prefix = depth-- > 0? sp.trySplit(): null;
    return prefix == null?
        new Tree<>(sp): new Tree<>(null, split(prefix, depth), split(sp, depth));
}

public static class Tree<T> {
    final T value;
    List<Tree<T>> children;

    public Tree(T value) {
        this.value = value;
        children = Collections.emptyList();
    }
    public Tree(T value, Tree<T>... ch) {
        this.value = value;
        children = Arrays.asList(ch);
    }
    public <U> Tree<U> map(Function<? super T, ? extends U> f) {
        Tree<U> t = new Tree<>(value == null? null: f.apply(value));
        if(!children.isEmpty()) {
            t.children = new ArrayList<>(children.size());
            for(Tree<T> ch: children) t.children.add(ch.map(f));
        }
        return t;
    }
    public @Override String toString() {
        if(children.isEmpty()) return value == null? "": value.toString();
        final StringBuilder sb = new StringBuilder(100);
        toString(sb, 0, 0);
        return sb.toString();
    }
    public void toString(StringBuilder sb, int preS, int preEnd) {
        final int myHandle = sb.length() - 2;
        sb.append(value == null? "": value).append('\n');
        final int num = children.size() - 1;
        if (num >= 0) {
            if (num != 0) {
                for (int ix = 0; ix < num; ix++) {
                    int nPreS = sb.length();
                    sb.append(sb, preS, preEnd);
                    sb.append("\u2502 ");
                    int nPreE = sb.length();
                    children.get(ix).toString(sb, nPreS, nPreE);
                }
            }
            int nPreS = sb.length();
            sb.append(sb, preS, preEnd);
            final int lastItemHandle = sb.length();
            sb.append("  ");
            int nPreE = sb.length();
            children.get(num).toString(sb, nPreS, nPreE);
            sb.setCharAt(lastItemHandle, '\u2514');
        }
        if (myHandle > 0) {
            sb.setCharAt(myHandle, '\u251c');
            sb.setCharAt(myHandle + 1, '\u2500');
        }
    }
}