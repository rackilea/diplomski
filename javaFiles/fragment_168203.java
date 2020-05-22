long timeAtLastAccept = System.nanoTime();
public void tick(){
    if(System.nanoTime()-timeAtLastAccept >threshold) {
         //Spawn your objects!
         timeAtLastAccept = System.nanoTime();
    } 

    //do ticky things
}