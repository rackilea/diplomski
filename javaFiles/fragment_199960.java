// Load all values and mark them all as "changed"
record.from(object);

// Undo the undesired flags
for (int i = 0; i < record.size(); i++)
    if (Objects.equals(record.get(i), record.original(i)))
        record.changed(i, false);