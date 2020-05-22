List<GameEntry> selectedEntries =  leaderBoardUserEntryMap.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.comparing(GameEntry::getScore, Integer::compare)
                    .reversed())).map(Map.Entry::getValue).collect(Collectors.toList());

int indexOfnewEntry = selectedEntries.indexOf(leaderBoardUserEntryMap.get(uid));
return  selectedEntries.subList(indexOfnewEntry-2,indexOfnewEntry+2);