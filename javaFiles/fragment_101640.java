public static Hitbox createHitbox(HitboxType hitboxType) {
    switch(hitboxType) {
       /* ... */
    }
    //in case of invalid parameter
    return new EmptyHitbox();
}