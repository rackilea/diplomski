//Generate vertices as random points on JPanel.
// Pass "0" as the argument to the constructor of Random, so that it 
// will always create the same sequence of random numbers
Random r = new Random(0);

// Create lists that will store the point coordinates
List<Integer> pointsX = new ArrayList<Integer>();
List<Integer> pointsY = new ArrayList<Integer>();

for (int l = 0; l < adj_Matrix_Edges.length; l++){
    String str = Integer.toHexString(l);
    //Define where a specific vertex will fall on a x, y coordinate
    //inside the container.
    x = Math.abs(r.nextInt()) % w;
    y = Math.abs(r.nextInt()) % h;

    // Store the coordinates of the points:
    pointsX.add(x);
    pointsY.add(y);

    //Initialize a node graphics object to represent vertices.
    Graphics2D node = (Graphics2D)g;
    node.fillOval(x, y, 7, 7); //Creates filled ovals for nodes.
    graph.drawString(str, x, y + 20);
}

//Create a nexted for loop to see if there is an edge between vertices.
for (int m = 0; m < adj_Matrix_Edges.length; m++){
    for (int n = 0; m < adj_Matrix_Edges[m].length; m++){
        if (adj_Matrix_Edges[m][n]){

            // Fetch the coordinates of the points from the list
            int xm = pointsX.get(m);
            int ym = pointsY.get(m);
            int xn = pointsX.get(n);
            int yn = pointsY.get(n);
            graph.drawLine(xm,ym,xn,yn);
        }
    }
}