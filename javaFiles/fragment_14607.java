String json = "\"{\"Employee\":[{\"id\":111589,\"firstName\":\"govind\",\"lastName\":\"Lname1\",\"company\":\"ABC\",\"No1\":1,\"Test\":null,\"Test1\":\"name1\"},{\"id\":12345,\"firstName\":\"name2\",\"lastName\":\"Lname2\",\"company\":\"ABC\",\"No1\":2,\"Test\":null,\"Test1\":\"name2\"},{\"id\":14567,\"firstName\":\"name3\",\"lastName\":\"Lname3\",\"company\":\"DEF\",\"No1\":3,\"Test\":null,\"Test1\":\"name3\"},{\"id\":1212,\"firstName\":\"govi\",\"lastName\":\"l1\",\"company\":\"Ac\",\"No1\":4,\"Test\":0,\"Test1\":\"name4\"},{\"id\":1212,\"firstName\":\"govi\",\"lastName\":\"l1\",\"company\":\"Ac\",\"No1\":5,\"Test\":0,\"Test1\":\"name4\"}]}\"";

    if (json.charAt(0) == '"' && json.charAt(json.length() - 1) == '"') {

        json = json.substring(1, json.length() - 1);

    }

    System.out.println("JSON is : " + json);