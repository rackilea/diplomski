for (int x = 0; x < some_list.length; x++) {
      some_list[x] = wp.new dataList();
        some_list[x].firstName = "John";
        some_list[x].middleName = "Jacob";
        some_list[x].lastName = "Jingle-Heimer-Schmidt";
        some_list[x].age = 101;
    }

    for (int x = 0; x < some_list.length; x++) {
        System.out.println(some_list[x].firstName + " "
                + some_list[x].middleName + " " + some_list[x].lastName
                + " Age: " + some_list[x].age);
    }

}

public class dataList {
    String firstName, middleName, lastName;
    int age;

    public dataList() {
        firstName = "";
        middleName = "";
        lastName = "";
        age = 0;
    }
}