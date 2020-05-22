List<Counter> toRemove = new ArrayList<Counter>();

Collections.sort(interval, (first, second) -> {

        int c = 0;

        if (first.compareWith(second)) {
            if (first.getCount() <= second.getCount()())
                toRemove.add(first);
            else if (first.getCount() >= second.getCount())
                toRemove.add(second);
        } else 
            c = first.getCount().compareTo(second.getCount());

        return c;
    }
);

interval.removeAll(toRemove);