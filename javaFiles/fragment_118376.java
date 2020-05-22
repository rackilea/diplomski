BufferedReader BR = new BufferedReader(new FileReader(new File(textfile)));

String assign;

while((assign = BR.readLine()) != null){

    String[] splitting= assign.split(";");

    for(int i =0; i < splitting.length; i++) {
        System.out.println(splitting[i]);
    }  

}