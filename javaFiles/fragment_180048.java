public void act(){
    Growing = (int) (Math.random() * 4);
    age++;
    if (age < 6){
        handleGrowing();
    }
    else {
        removeSelfFromGrid();
    }
}

private void handleGrowing()
{
    switch(Growing){
    case 0:
        removeSelfFromGrid();
    case 1:
        world.add(new GrowingFlower());
    case 2:
        world.add(new GrowingFlower());
        world.add(new GrowingFlower());
    case 3:
        world.add(new GrowingFlower());
        world.add(new GrowingFlower());
        world.add(new GrowingFlower());
    case 4:
        world.add(new GrowingFlower());
        world.add(new GrowingFlower());
        world.add(new GrowingFlower());
        world.add(new GrowingFlower());
    }
}