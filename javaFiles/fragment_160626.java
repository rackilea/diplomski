public int searchJunction(IRobot robot) {
    Iterator<Junction> junctionIterator = junctionList.iterator();
    while (junctionIterator.hasNext()) {
        Junction currentJunction = junctionIterator.next(); 
        if ((((currentJunction.x)==(robot.getLocation().x))) && ((currentJunction.y)==(robot.getLocation().y))) 
            break;
    }

    return currentJunction.arrived;
}