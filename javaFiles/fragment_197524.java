markVisited[disX][disY] = true; // mark the current node as visited
if(tab[disX][disY - 1] != null && !markedVisited[disX][disY-1]){ // test if target cell is notvisited
    if (tab[disX][disY - 1].c == tab[disX][disY].c){

        floodFill(disX, disY - 1);

    }
}