public void marged(){
    try {
        BufferedReader br1 = null;
        BufferedReader br2 = null;

        String line1;
        String line2;
        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();

        br1 = new BufferedReader(new FileReader("C:\\Users\\Madhawa.se\\Desktop\\workingfox\\data1.txt"));
        br2 = new BufferedReader(new FileReader("C:\\Users\\Madhawa.se\\Desktop\\workingfox\\data2.txt"));

        while ((line1 = br1.readLine()) != null) {

            String[] split1 = line1.split(",");

            String line1word = split1[0].trim();
            String line1val = split1[1].trim();

            line2 = br2.readLine();

            if (line2 != null) {
                String[] split2 = line2.trim().split(",");

                String line2word = split2[0].trim();
                String line2val = split2[1].trim();

                ArrayList<String> list = new ArrayList();
                list.add(line2word);
                list.add(line2val);
                arrayList.add(list);

                if (line1word.equalsIgnoreCase(line2word)) {
                    String ok = line1word + "," + line1val + "," + line2val;
                    System.out.println(ok);
                }

            } else {
                String ok = line1word + "," + line1val + "," + doesexist(arrayList, line1word);
                System.out.println(ok);
            }

        }

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}