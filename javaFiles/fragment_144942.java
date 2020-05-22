public Clock (String theTime)
    {
        this(
            Integer.parseInt(theTime.substring(0,1)),
            Integer.parseInt(theTime.substring(3,4))
        );

    }