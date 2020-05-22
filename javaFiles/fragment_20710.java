List<Button> answer=new List<Button>();

private void ButtonClickEventHandler(object sender,EventArgs e)
{
    //I'm assuming you have a location property in each individual button,
    //and of course, the color.
    search(sender);
}

private void search(Button bt)
{
    int x=bt.x;
    int y=bt.y;
    bt.Visited=true;
    answer.Add(bt);
    if(x>0 && br[x-1][y].getColor()==bt.getColor() && !br[x-1][y].Visited) search(br[x-1,y]);
    if(x<14 && br[x+1][y].getColor()==bt.getColor() && !br[x+1][y].Visited) search(br[x+1,y]);
    if(y>0 && br[x][y-1].getColor()==bt.getColor() && !br[x][y-1].Visited) search(br[x,y-1]);
    if(y<14 && br[x][y+1].getColor()==bt.getColor() && !br[x][y+1].Visited) search(b[x,y+1]);
}