public class Main {

    public static void main(String[] args) {
        int number = 2;
        List<String> nodes = new ArrayList<>(Arrays.asList("Hello", "World!",
                "How", "Are", "You"));
        boolean change = true;
        while (change) {
            List<String> copy = new ArrayList<>(nodes);
            ListIterator<String> nodesIterator = copy.listIterator();
            while (nodesIterator.hasNext()) {
                nodesIterator.next();
                int fromIndex = nodesIterator.previousIndex();
                List<String> nodesToCheck = nodes.subList(fromIndex, Math.min
                        (fromIndex + number, nodes.size()));
                if ((nodesToCheck.equals(Arrays.asList("How", "Are")) ||
                        nodesToCheck.equals(Arrays.asList("Hello", "World!")))) {
                    for (String n : nodesToCheck) {
                        //ConcurrentModificationException thrown here
                        // at beginning of second iteration
                        nodesIterator.remove();
                        if (nodesIterator.hasNext()) {
                            nodesIterator.next();
                        }
                    }
                    nodesIterator.previous();
                    List<String> nodesToReplace = new ArrayList<>(Arrays.asList
                            ("replace"));
                    for (String n : nodesToReplace) {
                        nodesIterator.add(n);
                    }
                    nodes = copy;
                    change = true;
                    break;
                } else change = false;
            }
        }
        System.out.println(Arrays.toString(nodes.toArray()));
    }
}