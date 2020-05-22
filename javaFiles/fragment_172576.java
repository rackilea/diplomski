public void render(ShapeRenderer renderer) {
    /**
     * find the angle
     */
    float elapsedNanoseconds = TimeUtils.nanoTime() - initialTime;
    float elapsedSeconds = MathUtils.nanoToSec * elapsedNanoseconds;
    float elapsedPeriods = elapsedSeconds / 2.0f;
    float cyclePosition = elapsedPeriods % 1;

    float x = WORLD_SIZE / 2 + radius * MathUtils.cos(MathUtils.PI2 * cyclePosition);
    float y = WORLD_SIZE / 2 + radius * MathUtils.sin(MathUtils.PI2 * cyclePosition);

    float x2 = WORLD_SIZE / 2 + radius * MathUtils.sin(MathUtils.PI2 * -cyclePosition);
    float y2 = WORLD_SIZE / 2 + radius * MathUtils.cos(MathUtils.PI2 * -cyclePosition);


    renderer.set(ShapeType.Line);
    renderer.setColor(COLOR);

    renderer.line(position.x - x, position.y + y, position.x + x, position.y - y);
    renderer.line(position.x - x2, position.y + y2, position.x + x2, position.y - y2);
}