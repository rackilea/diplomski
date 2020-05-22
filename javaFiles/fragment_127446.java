public static int closestBarrier(GameObject object, GameObject[] barriers)
    {
        int closest = -1;
        float minDistSq = Float.MAX_VALUE;//ridiculously large value to start
        for (int i = 0; i < barriers.length - 1; i++) {
            GameObject curr = barriers[i];//current
            float dx = (object.getX()-curr.getX()); 
            float dy = (object.getY()-curr.getY()); 
            float distSq = dx*dx+dy*dy;//use the squared distance
            if(distSq < minDistSq) {//find the smallest and remember the id
                minDistSq = distSq;
                closest = i;
            }
        }

        return closest;
    }