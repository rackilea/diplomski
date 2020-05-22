List<Integer> findCollisions(int n)
{
    List<List<Integer>> collisions = new ArrayList<List<Integer>>(n);
    for(int i = 0; i < n; i++)
        collisions.add(new LinkedList<Integer>());
    int keys = n * n;

    for(int i = 0; i < keys; i++)
        collisions.get(hash(i)).add(i);

    for(List<Integer> collision : collisions)
        if(collision.size() >= n)
            return collision;
    return null; //this should never happen, due to pigeonholes, but compiler doesn't know
}