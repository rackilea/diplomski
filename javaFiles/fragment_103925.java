@Override
protected void paintComponent(Graphics gr)
{
    super.paintComponent(gr);
    Graphics2D g = (Graphics2D)g;

    for (int l = 0; l < adj_Matrix_Edges.length; l++){

        // Compute the x- and y-coordinates that the
        // node will have in this component. (That's 
        // why the coordinates that are stored in 
        // the "Node" class should always be 
        // between 0 and 1!)

        Node node = nodes.get(l);
        int ix = (int)(node.x * getWidth());
        int iy = (int)(node.y * getHeight());

        g.fillOval(ix, iy, 7, 7);
        graph.drawString(node.name, ix, iy + 20);
    }

    //Create a nested for loop to see if there is an edge between vertices.
    for (int m = 0; m < adj_Matrix_Edges.length; m++){
        for (int n = 0; m < adj_Matrix_Edges[m].length; m++){
            if (adj_Matrix_Edges[m][n]){

                Node nodeM = nodes.get(m);                    
                Node nodeN = nodes.get(n);
                int xm = (int)(nodeM.x * getWidth());
                int ym = (int)(nodeM.y * getHeight());
                int xn = (int)(nodeN.x * getWidth());
                int yn = (int)(nodeN.y * getHeight());
                graph.drawLine(xm,ym,xn,yn); 
            }
        }
    }
 }