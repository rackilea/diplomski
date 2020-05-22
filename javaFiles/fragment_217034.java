String dequeueQuery = "DECLARE " +
            " names namesarray;" +
            "   total integer;" +
            "   BEGIN " +
            "   names := namesarray('Kavita', 'Pritam', 'Ayan', 'Rishav', 'Aziz'); " +
            "   ? := names;"+
            " END;";