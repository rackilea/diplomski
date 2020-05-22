return Stream.of(values).allMatch(value -> {
            if (pairs.get(value) == null) {
                return false;
            }
            if ((pairs.get(value) instanceof Boolean)) {
                return true;
            }
            errors.add(value + " does not contain a valid boolean value");
            return false;
        });