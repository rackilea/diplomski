GameObject nthCloserGameObject = 
    gameObjects.stream()
               .sorted(Comparator.comparingInt(gameObject -> computeDistanceToPlayer(gameObject)))
               .skip(n - 1)
               .findFirst()
               .orElse(null);