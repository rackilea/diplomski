getOptionalHumanObject()
    .map((Human h1) -> human::getName)
    .ifPresent((String name) -> {
        System.out.printLn(name)
        invokeImportentHttpPostRequest(x)
     });