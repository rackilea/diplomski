List<ProjectileBase> projectilesHold = projectiles;
projectiles = Collections.unmodifiableList(projectiles);
try {
    for (Iterator<ProjectileBase> iterator = projectilesHold.iterator(); iterator.hasNext();) {
        // other code here is unchanged
    }
} finally {
    projectiles = projectilesHold;
}