try {
        name = scanner.next();
        keepGoing = false;
        if(name.contains(" "))
            throw new EmptyInputException();

    }