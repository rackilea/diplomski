public void draw()
{
    map_camera_handler.map_renderer.setView(map_camera_handler);
    map_camera_handler.map_renderer.render();       
    entity_handler.draw();
}