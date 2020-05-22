public int[] pieces = new int [64];
private void intialize(){

{
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
    //null pointer exception here           
                if(board[i][j] == RED)
                {
                    pieces[8*i+j] = R.drawable.red_piece;
                }
                else if(board[i][j] == BLACK)
                {
                    pieces[8*i+j] = R.drawable.black_piece;
                }
                else pieces[8*i+j] = 0;
            }
        }
}

}