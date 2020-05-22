public void updatePieces(float timeDelta) {
    // The amount of an acceleration depends on a force
    // in a specified direction. You can skip this, and just
    // give your object a velocity. But to consider acceleration
    // later on, you have to assign forces and resolve them in
    // their respective direction.
    mAccelerationX  = fResX / weight;             
    mAccelerationY  = fResY / weight; 

    // Consider the previous velocity and add the change
    // in velocity.
    mVelocityX = mVelocityX + (mAccelerationX * timeDelta);
    mVelocityY = mVelocityY + (mAccelerationY * timeDelta);

    mPositionX = mPositionX + (mVelocityX * timeDelta);
    mPositionY = mPositionY + (mVelocityY * timeDelta);
}