public void update(float delta)
{
    world_handler.update(delta);
    entity_handler.update(delta);
    map_camera_handler.setCameraBounds();
    wave_handler.update();
}