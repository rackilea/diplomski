public static void main(String[] args) {

    String startFile = "C:\\workspacePrototype\\some.csv";

    try {
        CSVReader reader = new CSVReader(new FileReader(startFile));
        String[] line = null;

        String[] headers = reader.readNext();


        List<List<String>> build = new ArrayList<List<String>>();

        List<String> tempArr;

        // generate headers
        for(String header : headers){
            tempArr = new ArrayList<String>();
            tempArr.add(header);
            build.add(tempArr);
        }


        // generate content
        while((line = reader.readNext())!=null){

            for (int i = 0; i < build.size(); i++) {
                tempArr = build.get(i);
                String val = line[i];
                tempArr.add(val);
                build.set(i, tempArr);
            }

        }

        System.out.println(Arrays.asList(build));


    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}