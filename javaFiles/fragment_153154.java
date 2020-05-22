Queue q = new Queue();
q.enqueue((v1, 0));
int[] counts = new int[] { 0,0,0,0,0 };

while (!q.empty()) {
    (v, dist) = q.dequeue();
    for(Vertex w : v.Neighbors()) {
        if(dist < 3)
            q.enqueue((w, dist+1));

        if(dist < 4 && w == v2)
            counts[dist+1]++;
    }
}