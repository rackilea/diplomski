BaseBallTeam kate1 = new BaseBallTeam("Kate", 2);
    BaseBallTeam kate2 = new BaseBallTeam("Kate", 2);
    BaseBallTeam mike1 = new BaseBallTeam("Mike", 4);
    BaseBallTeam mike2 = new BaseBallTeam("Mike", 2);

    List<BaseBallTeam> list = Arrays.asList(kate1, kate2, mike1, mike2);
    Map<String, Integer> map = list.stream()
            .collect(Collectors.toMap(t -> t.getTeamMember(), 
                                      k -> k.getHomeRuns(), 
                                      (t1, t2) -> t1 + t2)
                    );
    System.out.println(map);