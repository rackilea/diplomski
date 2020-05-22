static class Edge {
        private int first;
        private int second;

        public Edge(Scanner scanner) {
            this(scanner.nextInt(), scanner.nextInt());
        }

        public Edge(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        @Override
        public String toString() {
            return "Edge [first=" + first + ", second=" + second + "]";
        }
    }