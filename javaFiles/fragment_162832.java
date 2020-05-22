while(var.box.length < var.inputCount) {
    temp = new Box(rng.nextInt(width - var.inputSize), rng.nextInt(height - var.inputSize), var.inputSize, var.inputSize, var.box.length+1);
    iterationCount++;

    for(int j = 0; j < var.box.length; j++) {
        next = var.box[j];

        isOverLap = temp.getRect().intersects(next.getRect());
        isUnderUI = temp.getRect().intersects(new Rectangle(0, height - 65, 300, 65));
        if(!var.excludeUI) {
            isUnderUI = false;
        }

        if(isOverLap || isUnderUI) break;
    }

    if(!isOverLap && !isUnderUI) {
        var.box = addToArray(var.box, temp);
    }

    if(iterationCount >= var.maxIterations) {
        finished = false;

        break;
    }else {
        finished = true;
    }
}