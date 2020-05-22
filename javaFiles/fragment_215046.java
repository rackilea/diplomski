List<Person> personList = new ArrayList<Person>();

    while(true) {
        Person p =new Person();
        Scanner stdin = new Scanner(System.in);
        System.out.println("Enter name :");
        p.setName(stdin.next());
        System.out.println("Enter gender :");
        p.setGender(stdin.next());
        System.out.println("Enter age :");
        p.setAge(stdin.nextInt());
        personList.add(p);
        System.out.println("Do you want to add more ?(Y/N)");
        if(stdin.next().equalsIgnoreCase("N")) {
            break;
        }
    }
    Collections.sort(personList);
    System.out.println("The oldest person is " + personList.get(0).getName());