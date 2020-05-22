CriteriaQuery<Tuple> query = cb.createTupleQuery();
Root<Game> game = query.from(Game.class);
Join<Game, GameResult> result_mine = game.join("results");
Join<Game, GameResult> result_theirs = game.join("results");
query
        .multiselect(game, result_mine, result_theirs)
        .where(
                cb.equal(result_mine.get("player"),p1),
                cb.equal(result_theirs.get("player"),p2)
        );
List<Tuple> results = em.createQuery(query).getResultList();