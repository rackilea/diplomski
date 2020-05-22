protected void floodFill(final FloodFillGridPoint[][] grid,
        final FloodFillGridPoint centroid, IFloodFillGridVisualizer visualizer) {
        final Queue<FloodFillGridPoint> queue = new LinkedList<>();
        queue.add(centroid);
        while (!queue.isEmpty()) {
            final FloodFillGridPoint n = queue.poll();
            if ((n.color() == COLOR_WHITE) && !n.isProcessed()) {
                n.markProcessed();
                n.setColor(COLOR_BLACK);

                final FloodFillGridPoint west = getPoint(grid,n.x()-1,n.y());
                final FloodFillGridPoint east = getPoint(grid,n.x()+1,n.y());
                final FloodFillGridPoint north = getPoint(grid,n.x(),n.y()-1);
                final FloodFillGridPoint south = getPoint(grid,n.x(),n.y()+1);
                for(FloodFillGridPoint neighbor : Arrays.asList(west,east,north,south)){
                    if(neighbor!=null && neighbor.color()!=COLOR_BLACK){
                        queue.add(neighbor);
                    }
                }
                visualizer.visualize(grid, n);
            }
        }
    }