public class MyGameWorld {

Animation soldierAnimation ; 

Soldier [] soliders ;

public MyGameWorld(int numbers_of_soliders){

soliders = new Soldier[numbers_of_soliders];

//loop over the array to instantiate them 
for( int i =0; i < numbers_of_soliders;++i){
soliders[i] = new Soldier(randomx ,randomy ,-5); // randomx , randomy is random values you can supply 
}

//then instantiate the animation object
//first get the images 
Image [] sprites = new sprites [8]; 
sprites [0] = new Image ......


soldierAnimation = new Animation(0.2, sprites);// this will make it flip each 0.2 seconds you can put any value that fits your need 
}


//in the game loop update you soldiers 

for(int i =0 ; i <numbers_of_soliders ; ++i){
soliders[i].update(deltaTime);
}

then render them using the animation 
for(int i =0 ; i< number_of_soliders ; ++i){

drawOnScreenThisImageWithThisPosition( soliders[i].xpos, soliders[i].ypos,soldierAnimation.getKeyFrame(soliders[i].walkingTime, Animation.ANIMATION_LOOPING);


}

}