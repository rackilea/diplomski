int bestIndex = 0;

// Loop starts at 1 b/c we don't need to compare index 0 w/ 0
// i.e. # of comparisons is 1 minus the # of Cars
for(int i = 1; i < cars.length - 1; i++){ 

    if(cars[i].getPoints() > cars[bestIndex].getPoints()){
        bestIndex = i;
    }

}