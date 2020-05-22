public static void main(String[] args) {
        try {

            List<Company> companyList = new ArrayList<Company>();

            Company c1 = new Company("Test Company","111",111,89077.0);
            companyList.add(c1);
            Company c2 = new Company("Non Test Company","22",222,077.0);
            companyList.add(c2);

            String content=null;
            for(Company company:companyList)
            content+= company;

            File file = new File("D://output.txt");


            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }