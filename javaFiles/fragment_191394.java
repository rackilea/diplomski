LinkedList<String> list = new LinkedList<>(Arrays.asList("p", "r", "r", "q", "p", "p", "r"));

String prev = null, curr = "-", next = null;
for (Iterator<String> iter = list.iterator(); prev == null || ! "-".equals(next); prev = curr, curr = next) {
    next = (iter.hasNext() ? iter.next() : "-");
    if (prev != null)
        System.out.println(curr + prev + next);
}