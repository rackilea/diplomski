Item item[];

public void start(){
    if(easy){
        itemnumber = 6
    }else if(medium){
        itemnumber = 10
    }else if(insane){
        itemnumber = 20
    }
    item = new Item[itemnumber];
    for (int i = 0; i < item.length; i++) {
            item[i] = new SpotPlus(getWidth() + 500 * i);
    }