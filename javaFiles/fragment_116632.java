Point getObject(Square s){
{
    for(int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
            if( squares[i][j].equals(s) ) {
                return Point(i, j);
            }
        }
    }
    return null;
}