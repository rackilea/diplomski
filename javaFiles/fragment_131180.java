double[] xlist = {51.8, 10.3, 5.1, 2.6, 1.7, 1.29, 1.03, 0.86, 0.65, 0.52, 0.43, 0.37, 0.32, 0.29};
        double x = 9.9; //or whatever declare x to equal
        double high = xlist.length;
        double mid = 0.0, low = 0.0;
        while (low != high) {
                mid = (low + high) / 2;
                    if (xlist[(int)mid] > x) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
        System.out.println(xlist[(int)mid - 1] + "\n" + x + "\n" + 
xlist[(int)mid]);