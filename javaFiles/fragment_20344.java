Map<Boolean, List<LeadChannel>> mappedUp = groups
        .stream()
        .collect(Collectors.partitioningBy(channel -> 
                channel.getResolution().getId().equals(RESOLVED_STATUS)));

Map<String, List<LeadChannel>> finalMap = mappedUp.entrySet().stream()
        // in a similar manner you can map your current map's entries as well
        .map(e -> new AbstractMap.SimpleEntry<>(e.getKey() ? "resolved" : "unresolved", e.getValue())) 
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));