private void dfs(Point start, boolean[][] visited) {
    ArrayList<Point> nextCell = whatVisit(start, visited);
    if(nextCell == null)        // if there's nothing to visit
        return;

    // mark current cell as visited
    visited[start.y][start.x] = true;

    for (Point next : nextCell) // try new accessible cells
    {
        // destroy the wall between current cell and the new one
        borders[(start.y + next.y)/2][(start.x + next.x)/2] = true;    
        // start a new search from found cell
        dfs(next, visited);
    }
}

private ArrayList<Point> whatVisit(Point p, boolean[][] visited) {
    Vector<Point>cells = new Vector<Point>();   // to store acessible cells

    // lookaround
    if(p.x - 2 >= 0 && !visited[p.y][p.x - 2])
        cells.add(new Point(p.x - 2, p.y));
    if(p.x + 2 < visited[0].length && !visited[p.y][p.x + 2])
        cells.add(new Point(p.x + 2, p.y));
    if(p.y - 2 >= 0 && !visited[p.y - 2][p.x])
        cells.add(new Point(p.x, p.y - 2));
    if(p.y + 2 < visited.length && !visited[p.y + 2][p.x])
        cells.add(new Point(p.x, p.y + 2));

    // returns null if there are no accessible cells around
    if(cells.size() > 0)
    {
        ArrayList<Point> tmp = new ArrayList<Point>();
        // randomize how many cell that will be returned
        int x = (int)(Math.random()*cells.size()) + 1;
        if (x > cells.size())
            x = cells.size();
        Collections.shuffle(cells);
        for (int i = 0; i < x; i++)
            tmp.add(cells.get(i));
        return tmp;
    }
    else return null;
}