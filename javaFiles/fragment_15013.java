dbi.registerArgumentFactory(new CharArrayArgument());
    GameDao gameDao = dbi.open(GameDao.class);
    Game game = new Game(1, 2, 3, new char[][]{{'a'}, {'b'}});

    gameDao.createTableIfNotExists();
    gameDao.insert(game);