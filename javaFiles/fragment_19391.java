while((line = rf.readLine()) != null) {
    if(line.charAt(0)=='#'){
        scan.nextLine(); //use it to suit your need..
        //alert the program to prepare for new type of object
        //do something..
    }else {
        split = scan.nextLine().split(", ");
                pnumber = Integer.parseInt(split[0]);
                name = split[1];
                age = Integer.parseInt(split[2]);
                thePerson = new Person(name, age, pnumber);
                personList.addLast(thePerson);
    }
}