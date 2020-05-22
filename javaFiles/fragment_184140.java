public class SubWordFinder {

    private TreeSet<String> words = new TreeSet<String>();

    public SubWordFinder(Collection<String> words) {
        this.words.addAll(words);
    }

    public List<String> findSubWords(String word) throws NoSolutionFoundException {
        List<String> bestSolution = new ArrayList<String>();
        if (word.isEmpty()) {
            return bestSolution;
        }
        long length = word.length();
        int[] pointer = new int[]{0, 0};
        LinkedList<int[]> pointerStack = new LinkedList<int[]>();
        LinkedList<String> currentSolution = new LinkedList<String>();
        while (true) {
            boolean backtrack = false;
            for (int end = pointer[1] + 1; end <= length; end++) {
                if (end == length) {
                    backtrack = true;
                }
                pointer[1] = end;
                String wordToFind = word.substring(pointer[0], end);
                if (words.contains(wordToFind)) {
                    currentSolution.add(wordToFind);
                    if (backtrack) {
                        if (bestSolution.isEmpty() || currentSolution.size() < bestSolution.size()) {
                            bestSolution = new ArrayList<String>(currentSolution);
                        }
                        currentSolution.removeLast();
                    } else if (!bestSolution.isEmpty() && currentSolution.size() == bestSolution.size()) {
                        currentSolution.removeLast();
                        backtrack = true;
                    } else {
                        int nextStart = end;
                        int[] nextPointer = new int[]{nextStart, nextStart};
                        pointerStack.add(pointer);
                        pointer = nextPointer;
                    }
                    break;
                }
            }
            if (backtrack) {
                if (pointerStack.isEmpty()) {
                    break;
                } else {
                    currentSolution.removeLast();
                    pointer = pointerStack.removeLast();
                }
            }
        }
        if (bestSolution.isEmpty()) {
            throw new NoSolutionFoundException();
        } else {
            return bestSolution;
        }
    }

    public class NoSolutionFoundException extends Exception {

        private static final long serialVersionUID = 1L;

    }

}