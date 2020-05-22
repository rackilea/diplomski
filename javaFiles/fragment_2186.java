String[] activityName = new String[4];     
    activityName[0] = "Go and Have Fun";
    activityName[1] = "Hiya, Go Shooping";
    activityName[2] = "Get a job";
    activityName[3] = "Read a book";

    Random generator = new Random();
    int randomNumber = generator.nextInt(activityName.length);
    System.out.println(activityName[randomNumber]);