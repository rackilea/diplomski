public class SegmentsAlgorithm {

    private PriorityQueue<int[]> remainSegments = new PriorityQueue<>((o0, o1) -> Integer.compare(o0[0], o1[0]));
    private SegmentWeight[] arraySegments;

    public void addSegment(int begin, int end) {
        remainSegments.add(new int[]{begin, end});
    }

    public void prepareArrayCache() {
        List<SegmentWeight> preCalculate = new ArrayList<>();
        PriorityQueue<int[]> currentSegmentsByEnds = new PriorityQueue<>((o0, o1) -> Integer.compare(o0[1], o1[1]));
        int begin = remainSegments.peek()[0];
        while (!remainSegments.isEmpty() && remainSegments.peek()[0] == begin) {
            currentSegmentsByEnds.add(remainSegments.poll());
        }
        preCalculate.add(new SegmentWeight(begin, currentSegmentsByEnds.size()));
        int next;
        while (!remainSegments.isEmpty()) {
            if (currentSegmentsByEnds.isEmpty()) {
                next = remainSegments.peek()[0];
            } else {
                next = Math.min(currentSegmentsByEnds.peek()[1], remainSegments.peek()[0]);
            }
            while (!currentSegmentsByEnds.isEmpty() && currentSegmentsByEnds.peek()[1] == next) {
                currentSegmentsByEnds.poll();
            }
            while (!remainSegments.isEmpty() && remainSegments.peek()[0] == next) {
                currentSegmentsByEnds.add(remainSegments.poll());
            }
            preCalculate.add(new SegmentWeight(next, currentSegmentsByEnds.size()));
        }
        while (!currentSegmentsByEnds.isEmpty()) {
            next = currentSegmentsByEnds.peek()[1];
            while (!currentSegmentsByEnds.isEmpty() && currentSegmentsByEnds.peek()[1] == next) {
                currentSegmentsByEnds.poll();
            }
            preCalculate.add(new SegmentWeight(next, currentSegmentsByEnds.size()));
        }
        SegmentWeight[] arraySearch = new SegmentWeight[preCalculate.size()];
        int i = 0;
        for (SegmentWeight l : preCalculate) {
            arraySearch[i++] = l;
        }
        this.arraySegments = arraySearch;
    }

    public int searchPoint(int p) {
        int result = 0;
        if (arraySegments != null && arraySegments.length > 0 && arraySegments[0].begin <= p) {
            int index = Arrays.binarySearch(arraySegments, new SegmentWeight(p, 0), (o0, o1) -> Integer.compare(o0.begin, o1.begin));
            if (index < 0){  // Bug fixed
                index = - 2 - index;
            }
            if (index >= 0 && index < arraySegments.length) { // Protection added
                result = arraySegments[index].weight;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SegmentsAlgorithm algorithm = new SegmentsAlgorithm();
        int[][] segments = {{0, 5},{3, 10},{8, 9},{14, 20},{12, 28}};
        for (int[] segment : segments) {
            algorithm.addSegment(segment[0], segment[1]);
        }
        algorithm.prepareArrayCache();

        int[] points = {-1, 2, 4, 6, 11, 28};

        for (int point: points) {
            System.out.println(point + ": " + algorithm.searchPoint(point));
        }
    }

    public static class SegmentWeight {

        int begin;
        int weight;

        public SegmentWeight(int begin, int weight) {
            this.begin = begin;
            this.weight = weight;
        }
    }
}