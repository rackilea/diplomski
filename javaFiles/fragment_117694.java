for(Actor actor : stage.getActors())
{
    Vector3 windowCoordinates = new Vector3(actor.getX(), actor.getY(), 0);
    camera.project(windowCoordinates);
    if(windowCoordinates.x + actor.getWidth() < 0)
        actor.remove();
}