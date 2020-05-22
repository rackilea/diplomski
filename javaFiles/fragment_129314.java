public static int[][] read2DArray(String fileName) throws FileNotFoundException {

        Scanner sc = null;

        List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        int columnCount = 0;
        int[][] arr = null;

        try {

            sc = new Scanner(new File(fileName));

            while (sc.hasNextLine()) {

                // Read line
                String line = sc.nextLine();

                // Split it
                String[] nums = line.split(" ");

                if (nums.length > columnCount) {
                    columnCount = nums.length;
                }

                // Convert to integers and add to list
                list.add(new ArrayList<Integer>());
                for (String n : nums) {
                    list.get(list.size() - 1).add(new Integer(n));
                }
            }

            // Convert list to array
            int rowCount = list.size();
            arr = new int[rowCount][columnCount];
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < list.get(i).size(); j++) {
                    arr[i][j] = list.get(i).get(j);
                }
            }

        } finally {
            if (sc != null) {
                sc.close();
            }
        }

        return arr;
    }