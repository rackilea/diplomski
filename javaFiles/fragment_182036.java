// test list
List<String> duplicates = new ArrayList<>(
    Arrays.asList(
        new String[]{
            "pagoda", "hour", "hour experience", "pagoda", "car", "eatables", 
            "eatables water", "walk", "small", "small garden", "little", 
            "little hot", "jungle", "jungle beach", "restaurant", "ocean", 
            "local", "room", "morning", "guy", "pagoda small", "small garden", 
            "hour experience", "peaceful environment", "view"
        }
    )
);
// manipulating to Set with collections stream API
Set<String> noDuplicates = duplicates
    .stream()
    .filter(
        (s) -> duplicates.stream()
        // negative filter from original list
        .noneMatch(
            // condition: longer string that starts with current string
            (ss) -> ss.length() > s.length() && ss.startsWith(s)
        )
    )
    .collect(Collectors.toSet());

System.out.println(noDuplicates);