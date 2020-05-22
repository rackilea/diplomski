public int readfile(String searchedString, File txtfile){
int ret = 0;

        try {
        BufferedReader br = new BufferedReader(new FileReader(txtfile));

        String line = null;
        while ((line = br.readLine()) != null) {
            if (line.startsWith(searchedString + " ")) {
                String[] strArr = line.split(" ");
                int item = strArr.length - 1;
                ret = Integer.parseInt(strArr[item]);
            }
        }

        br.close();
        System.out.println(ret);

        } catch (IOException ex) {
           //handle it
        }
     return ret;
}