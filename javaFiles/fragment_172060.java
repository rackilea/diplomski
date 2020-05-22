static int daysInARow(List<Instant> allInstants, Duration maxDifference) {
        int counter = allInstants.size() > 0 ? 1 : 0;
        Instant previous = allInstants.get(0);

        for (int i = 1; i < allInstants.size(); i++) {
            Instant current = allInstants.get(i);
            if (Duration.between(previous, current).compareTo(maxDifference) > 0)
                break;
            counter++;
            previous = current;
        }

        return counter;
    }