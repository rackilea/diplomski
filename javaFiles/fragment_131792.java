BufferedReader R = new BufferedReader(new FileReader(
        "list_of_1000_cities with coords.txt"));





while ((FileLine = R.readLine()) != null) {
    String[] Tokens = FileLine.split(",");


    if (Preprocessor.get_double(Tokens[1])!=0 && Preprocessor.get_double(Tokens[2])!=0) {

    city x = new city() ;

    x.latitude= Double.parseDouble(Tokens[1]);


    x.longitude= Double.parseDouble(Tokens[2]);

    x.name= Tokens[0];
    citylist.add(x );

    System.out.println(citylist.get(citylist.size() - 1).name);
     //prints the correct name

    }
}

    System.out.println(citylist.get(1115).name);