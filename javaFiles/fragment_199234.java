al.removeAll(
    al.stream().filter(
        ball -> {
            List<Enemy> enemies = al2.stream()
                .filter(enemy -> ball.x == enemy.x && ball.y == enemy.y)
                .collect(Collectors.toList());
            al2.removeAll(enemies);
            return !enemies.isEmpty();
        }
    ).collect(Collectors.toList())
);