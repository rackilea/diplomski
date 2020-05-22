String currentString = Datas;


    String[] separated = currentString.split(":DENEME:");
    for (int i=1; i<separated.length;i++) {


        Person person = new Person(""+(i) + "", separated[i],"");
        persons.add(person);

    }