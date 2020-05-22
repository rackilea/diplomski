GameObject nthCloserGameObject = 
    gameObjects.stream()
               .map(gameObject -> new GameObjectWithDistance(gameObject, computeDistanceToPlayer(gameObject)))
               .sorted(Comparator.comparingInt(GameObjectWithDistance::getDistance))
               .skip(n - 1)
               .findFirst()
               .map(GameObjectWithDistance::getGameObject)
               .orElse(null);