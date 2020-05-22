try {
            LineNumberReader lnr = new LineNumberReader(new FileReader(new File("lista de numeros.txt")));
            int linenumber = 0;
            int primero = 0;
            ArrayList<Integer> tmpArrayList = new ArrayList();
            String tmp = new String();
            tmp = lnr.readLine();
            while (tmp != null) {
                tmpArrayList.add(Integer.parseInt(tmp));
                linenumber++;
                JOptionPane.showMessageDialog(null, (tmp));
                tmp = lnr.readLine();

            }
            int mitad = (0 + linenumber) / 2;
            int[] array = new int[linenumber];
            for (int i = 0; i < array.length; i++) {
                array[i] = tmpArrayList.get(i).intValue();
            }