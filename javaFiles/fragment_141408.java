public static Vector2 screenToPhysics(Camera camera, Vector2 screenPos) {
    Vector3 worldPos = camera.unproject(new Vector3(screenPos.x, screenPos.y, 0));
    return new Vector2(worldPos.x, worldPos.y).scl(1f / PIXEL_TO_METER);
}

public static Vector2 physicsToScreen(Camera camera, Vector2 physicsPos) {
    Vector3 worldPos = new Vector3(physicsPos.x, physicsPos.y, 0).scl(PIXEL_TO_METER);
    Vector3 screenPos = camera.project(worldPos);
    return new Vector2(screenPos.x, screenPos.y);
}