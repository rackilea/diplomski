public State(State another){
    this.room = new long[another.room.length][another.room.length];
    ....

    for(int i=0; i<this.room.length; i++)
        for(int j=0; j<this.room.length; j++)
            this.room[i][j] = another.room[i][j];
}

...
private successFunction() {
  ...
  for(i=1;i<=3;i++){
     temp.room[x][y+i]=0;
  }