if (low_index < j) {
            System.out.println("Running 1");
            System.out.println(j + " " + low_index);
            quickSort(low_index, j, "Run 1---------");
            //recursive code invoked, but prevent the control to process downstream code
            return;
        }