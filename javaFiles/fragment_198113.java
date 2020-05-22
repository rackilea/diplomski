public void getData(String path, String accountNumber) {
    try {
        FileInputStream fis = new FileInputStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        System.out.println("Please Enter the Deposit amount That you would like to add.");

        Scanner sn = new Scanner (System.in);

        int add = sn.nextInt();

        String line; // current line
        String input = ""; // overall input

        while ((line = br.readLine()) != null) {
            if (line.contains(accountNumber)) {
                String[] array = line.split(" ");
                int old = Integer.parseInt(array[3]);
                int Sum= old + add;
                String Sumf = Integer.toString(Sum);
                array[3] = Sumf;

                // rebuild the 'line' string with the modified value
                line = "";
                for (int i = 0; i < array.length; i++)
                    line+=array[i]+" ";
                line = line.substring(0,line.length()-1); // remove the final space
            }

            // add the 'line' string to the overall input
            input+=line+"\n";
        }

        // write the 'input' String with the replaced line OVER the same file
        FileOutputStream fileOut = new FileOutputStream(path);
        fileOut.write(input.getBytes());
        fileOut.close();
    } catch (Exception ex) {
        System.out.println(ex);
    }
}