Override
public int getItemViewType(int position){
    int beforeLast = GameData.totalPlayers-1;
    // return a unique number
    if(beforeLast == position) {
        return 1; // some unique id
    }else {
        return 0;
    }
}