public static void main(String[] args) throws IOException {

        //Read file
        //Parse line by line
        //Map into person object
        List<Person> personList = Files
                .lines(Paths
                        .get("D:\\Project\\Code\\src\\main\\resources\\person.txt"))
                .map(line -> {

                            //Get lines of test and split by ","
                            //It split words of the line and push them into  an array of string. Like "John,Doe" -> [John,Doe]
                            List<String> nameAndFamily = Splitter.on(",").trimResults().omitEmptyStrings().splitToList(line);

                            //Create a new Person and get above words
                            Person person = new Person();
                            person.setName(nameAndFamily.get(0));
                            person.setFamily(nameAndFamily.get(1));
                            return person;
                        }
                ).collect(Collectors.toList());



        //Process the person list
        personList.forEach(person -> {
            //You can whatever you want to the each person 
            //Print
            System.out.println(person.getName());
            System.out.println(person.getFamily());
        });


    }