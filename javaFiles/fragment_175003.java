String test =
    "ACCEPT pasta "
       + "WITH tomatoes, parmesan cheese, olives "
       + "WITH anchovies WITH tuna WITH more olives.";

System.out.println(
    test.replaceAll(
        "(ACCEPT.*?WITH.*?)(?:\\s*WITH.*)(\\.)", "$1$2"
    )
);