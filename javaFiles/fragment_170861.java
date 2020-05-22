public static double bulletAcuracy(int bulletHits, int totalBulletsFired)
{
    if(totalBulletsFired == 0)
        return 0;

    return bulletHits/((double)totalBulletsFired);
}