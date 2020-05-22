Arrays.sort(list, new Comparator<File>()
    {
        public int compare(File file1, File file2)
        {
            int result = ...
            .... comparison logic
            return result;
        }
    });