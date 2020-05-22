java.util.Arrays.sort(d2, new java.util.Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    if (a.length != b.length) {
                        return a.length < b.length ? -1 : 1;
                    }
                    return a[0] - b[0];
                }
            });