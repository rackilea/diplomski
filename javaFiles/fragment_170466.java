// assume this is code run when no input
if(move != 0){
    if(Math.abs(move) < moveAmount){ // if close to zero set to zero
       move = 0;
    }else{
       move -= Math.sign(move) * moveAmount; // else move towards zero at
                                             // fixed rate
    }
}