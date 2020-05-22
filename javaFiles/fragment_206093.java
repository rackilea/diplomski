String email = "test@test.de";
    String[] For_split_email = email.split("[@._]");
    for (int j = 0; j <= For_split_email.length - 1; j++)
    {
        System.out.println("splited emails----------" + For_split_email[j]);
    }