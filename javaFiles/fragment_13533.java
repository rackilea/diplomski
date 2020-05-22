for(TestClass testClass: list){

    if(!testClass.getAppId().equals("id") &&
        !testClass.getStatus().equals("Status") &&
        !testClass.getMessage().equals("Message")){

        list.add(testClass);
    }
}

dataProvider.refresh();