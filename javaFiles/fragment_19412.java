public void removeLikeColorsFrom(ColorShape[][] _tiles, int x, int y){
    Color colorToReturn = _tiles[x][y].getColor();
    Stack<Point> stack = new Stack<Point>();
    stack.add(new Point(x,y));
    while(!stack.empty()){
        Point next = stack.pop();
        //check if this shape is the proper color
        if(_tiles[next.x][next.y].getColor().equals(colorToReturn)){
            _tiles[next.x][next.y] = null;
            x = next.x;
            y = next.y;
            //now push all neighbors onto stack for processing
            if(x-1>-1 && _tiles[x-1][y]!=null) 
                stack.push(new Point(x-1,y));
            if(x+1<tiles.length) 
                stack.push(new Point(x+1,y));
            if(y+1<tiles[0].length) 
                stack.push(new Point(x,y+1));
            if(y-1>-1) 
                stack.push(new Point(x,y-1));
        }
    }
}