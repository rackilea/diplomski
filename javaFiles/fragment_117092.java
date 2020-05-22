Map<String, List<Votes>> grouped = voteCountList.stream().collect(Collectors.groupingBy(r->r.getName()));

List<Votes> collectedList = new ArrayList<>();

grouped.forEach((groupName, votes) -> collectedList.add(new Votes(groupName,
                votes.stream().collect(Collectors.summingInt(r->r.getLikes())),
                votes.stream().collect(Collectors.summingInt(r->r.getDislikes())))));