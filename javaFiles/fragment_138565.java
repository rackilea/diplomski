public static int getVertical(final List<List<Integer>> list) {
        int result = 0;
        for (List<Integer> arr : list) {
            int curr = 0;
            for (Integer val : arr)
                curr += val;
            if (curr > result)
                result = curr;
        }
        return result;
    }