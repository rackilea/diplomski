int k = 5;
    int count = 0;
    ArrayList<Integer> ArrGirls = new ArrayList<>((List<Integer>) Arrays.asList(new Integer[]{34, 37, 28, 16, 44, 36, 37, 43, 50, 22}));
    ArrayList<Integer> ArrBoys = new ArrayList<>((List<Integer>) Arrays.asList(new Integer[]{13, 28, 41, 10, 14, 27, 41, 27, 23, 37}));
    for (Iterator<Integer> iteG = ArrGirls.iterator(); iteG.hasNext();) {
        {
            Integer ArrGirl = iteG.next();
            for (Iterator<Integer> iteB = ArrBoys.iterator(); iteB.hasNext();) {
                Integer ArrBoy = iteB.next();
                int dif = (int) Math.abs(ArrBoy - ArrGirl);
                if (dif <= k) {
                    System.out.println("we took " + ArrBoy + " from boys with "
                            + ArrGirl + " from girls, thier dif is " + dif);
                    ArrBoys.remove(ArrBoy);
                    ArrGirls.remove(ArrGirl);
                    iteG = ArrGirls.iterator();//You have to reset the value of iterationGirls
                    count++;
                    break;
                }
            }
        }
    }
    System.out.println(count);