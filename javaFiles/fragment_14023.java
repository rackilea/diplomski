for(int i=0;i<n;i++) {
        int age;
        String name;
        age = sc.nextInt();
        name = sc.next();
        humans[i] = new Human(); // Add This
        humans[i].age=age;
        humans[i].name=name;
    }