String dequeueQuery = "DECLARE " +
            " type namesarray IS VARRAY(5) OF VARCHAR2(10); " +
            " names namesarray;" +
            "   total integer;" +
            "   BEGIN " +
            "   names := namesarray('Kavita', 'Pritam', 'Ayan', 'Rishav', 'Aziz'); " +
            "   ? := names;"+
            " END;";