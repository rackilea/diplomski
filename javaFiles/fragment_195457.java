public static void main(String[] args)
{
    p = new PriorityQueue<Node>();
    int numInserted = 0;

    cost = new int[13][11];

    for (int[] row : cost)
        Arrays.fill(row, -1);

    cost[0][8]  = 366564;
    cost[2][9]  = 368282;
    cost[1][3]  = 368282;
    cost[4][9]  = 368282;
    cost[0][9]  = 376564;
    cost[1][9]  = 372423;
    cost[5][9]  = 372423;
    cost[0][3]  = 436564;
    cost[7][0]  = 378282;
    cost[2][10] = 378282;
    cost[4][10] = 378282;
    cost[0][4]  = 382423;
    p.add(new Node(0, 8, 8, numInserted));
    numInserted++;
    p.add(new Node(2, 9, 8, numInserted));
    numInserted++;
    p.add(new Node(1, 3, 7, numInserted));
    numInserted++;
    p.add(new Node(4, 9, 2, numInserted));
    numInserted++;
    p.add(new Node(0, 9, 8, numInserted));
    numInserted++;
    p.add(new Node(1, 9, 8, numInserted));
    numInserted++;
    p.add(new Node(5, 9, 2, numInserted));
    numInserted++;
    p.add(new Node(0, 3, 6, numInserted));
    numInserted++;
    p.add(new Node(7, 0, 3, numInserted));
    numInserted++;
    p.add(new Node(2, 10, 8, numInserted));
    numInserted++;
    p.add(new Node(4, 10, 2, numInserted));
    numInserted++;
    p.add(new Node(0, 4, 7, numInserted));
    numInserted++;

    while (p.size() != 0) {
        Node n1 = p.poll();
        System.out.println(n1.x + " " + n1.y + " " + cost[n1.x][n1.y]);
    }
}