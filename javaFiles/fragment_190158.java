entries = entries.stream().filter(e -> {
        boolean result = true;
        if (!Integer.toString(e.getId()).equals(args[1])) {
            doneEntries.add(new Entry(e.getTitle(), e.getDescription(), "done", e.getTags(), doneEntries.size() + 1));
            result = false;
        }
        return result;
    }).collect(Collectors.toList());