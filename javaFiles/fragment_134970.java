static class SortingThread implements Callable<String[]> {

        private File file;
        private String[] sortedData = new String[0];

        public SortingThread(File file) {
            this.file = file;
        }

        public String[] getSortedData() {
            return sortedData;
        }

        @Override
        public String[] call() throws Exception {
            String[] data = getData(file);
            data = MergeSort.mergeSort(data);
            sortedData = MergeSort.merge(sortedData, data);
            return sortedData;
        }
    }