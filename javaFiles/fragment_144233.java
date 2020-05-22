public void DoSomething(){
    String[] args = {"-app", "app1", "app2", "app3", "app4", "app5", "-env", "env1", "env2", "env3", "env4"};
    List<String> appList = new ArrayList();
    List<String> envList = new ArrayList();

    int indexOfApp = -1;
    int indexOfEnv = -1;

    for(int i = 0; i<args.length; i++){
        if(args[i].equals("-app")){
            indexOfApp = i;
        }else if(args[i].equals("-env")){
            indexOfEnv = i;
        }
    }

    int countOfApp = -1;
    int countOfEnv = -1;

    if(indexOfApp != -1 && indexOfEnv != -1){
        countOfApp = indexOfEnv - 1;
        countOfEnv = args.length - (indexOfEnv + 1);
    }


    System.out.println(countOfApp);
    System.out.println(countOfEnv);

    for(int appIndex = indexOfApp; appIndex < countOfApp; appIndex++){
        appList.add(args[appIndex]);
    }

    for(int envIndex = indexOfEnv + 1; envIndex < args.length; envIndex++){
        envList.add(args[envIndex]);
    }


    Assert.assertEquals(5, appList.size());
    Assert.assertEquals(4, envList.size());

}