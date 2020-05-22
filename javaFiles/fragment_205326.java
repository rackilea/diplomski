if (player.isWalking){
    mTimeToNextStep -= deltaTime;
    if (mTimeToNextStep < 0){
        play(single_footstep);
        while (mTimeToNextStep < 0){ //in case of a really slow frame, 
                                    //make sure we don't fall too far behind
            mTimeToNextStep += TIME_BETWEEN_STEP_SOUNDS;
        }
    }
} else {
    mTimeToNextStep = 0; //or whatever delay you want for the first sound when
                         //you start walking
}