public MovesValue(int value) {              // <<== Changed the type of value
    this.value = value;
}
...
double moveToMake = beginMoves;            
MovesValue rv = new MovesValue(moveToMake); // <<== This does not compile