protected Level1() throws RuntimeException {
        if (getClass().equals(Level1.class)) {
            return;
        }

        if (getClass().getSuperclass().equals(Level1.class)) {
            return; // first level or inheritance
        }

        if (getClass().getSuperclass().getSuperclass().equals(Level1.class)) {
            return; // second level or inheritance
        }
        // else
        throw new RuntimeException("Can't implement more than 2 levels");
    }