Vector2 closestVecky = null;
float shortestDistance = -1;
for (Vector2 vecky : map){
    float veckyDist = vecky.dst();
    if (closestVecky==null || veckyDist < shortestDistance){
        shortestDistance = veckyDist;
        closestVecky = vecky;
    }
}
//when you reach here, you will have your `closestVecky` and `shortestDistance`