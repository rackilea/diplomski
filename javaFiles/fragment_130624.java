List<Player> players = new ArrayList<Player>() {{
        add(new Player(1L, "a", 5));
        add(new Player(2L, "b", 7));
        add(new Player(3L, "c", 8));
        add(new Player(4L, "d", 9));
        add(new Player(5L, "e", 3));
        add(new Player(6L, "f", 8));
     }};
     int[] score = {Integer.MIN_VALUE};
     int[] no = {0};
     int[] rank = {0};
     List<Ranking> ranking = players.stream()
         .sorted((a, b) -> b.getScores() - a.getScores())
         .map(p -> {
             ++no[0];
             if (score[0] != p.getScores()) rank[0] = no[0];
             return new Ranking(rank[0], score[0] = p.getScores());
         })
         // .distinct() // if you want to remove duplicate rankings.
         .collect(Collectors.toList());
     System.out.println(ranking);
    // result:
    // rank=1, score=9
    // rank=2, score=8
    // rank=2, score=8
    // rank=4, score=7
    // rank=5, score=5
    // rank=6, score=3