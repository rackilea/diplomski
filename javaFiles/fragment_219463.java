BufferedReader csv = new BufferedReader(new FileReader("test.csv"));

    String line;

    ArrayList<String> ar1 = new ArrayList<String>();
    ArrayList<String> ar2 = new ArrayList<String>();

    String s1=null,s2=null;

    String[] lineSplit;

    while ((line = csv.readLine()) != null){

        lineSplit = line.split(",");
        if(lineSplit.length>1){ 
            if(!lineSplit[0].equals("null")){

                if(!ar1.isEmpty()){

                    System.out.println(s1+","+ar1.toString().replaceAll(", ", ";")
                                       +","+ar2.toString().replaceAll(", ", ",")+","+s2);
                }

                s1 = lineSplit[0] ;
                s2 = lineSplit[3];
                ar1 = new ArrayList<String>();
                ar1.add(lineSplit[1]);
                ar2 = new ArrayList<String>();
                ar2.add(lineSplit[2]);
            }
            else{
                ar1.add(lineSplit[1]);
                ar2.add(lineSplit[2]);
            }
        }
    }

    System.out.println(s1+","+ar1.toString().replaceAll(", ", ";")
               +","+ar2.toString().replaceAll(", ", ",")+","+s2);

    csv.close();