System.out.println("After Sort");
        AgeComparator ageComparator=new AgeComparator();
        Collections.sort(list, ageComparator);
        for(UserDetails detail:list) {
            System.out.println(detail);
        }