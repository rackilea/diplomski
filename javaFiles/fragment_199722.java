public String getRandomString(){
        Random r = new Random();

        int i = r.nextInt()%3;

        switch (i) {
            case 0:
                return one;
            case 1:
                return two;
            case 2:
                return three;
            default:
                break;
        }

    }