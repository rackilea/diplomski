private class Test {
        public String field = new String("1");
        {
            field = new String("2");
        }

    }