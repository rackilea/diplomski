Map<String, Map<String, Map<String, Set<String>>>> level3Map;

// gives a stream of all the flattened values
level3Map.entrySet()
         .stream()
         .flatMap(entry -> entry.getValue().entrySet().stream())
         .flatMap(entry -> entry.getValue().entrySet().stream())
         .flatMap(entry -> entry.getValue().stream());

// gives a stream of FlatEntries with flattened values and all their original elements in nested FlatEntries
level3Map.entrySet()
         .stream()
         .flatMap(GdkStreams.flatEntryMapper(entry -> entry.getValue().entrySet().stream()))
         .flatMap(GdkStreams.flatEntryMapper(flatEntry -> flatEntry.value.getValue().entrySet().stream()))
         .flatMap(GdkStreams.flatEntryMapper(flatEntry -> flatEntry.value.getValue().stream()));