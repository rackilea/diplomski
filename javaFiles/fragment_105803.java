List<Catapult> projectile = new List<Catapult>();
for (int i = 0; i < angle.Length; i++)
{
    for (int j = 0; j < velocity.Length; j++)
    {
        Catapult cata = new Catapult(angle[i], velocity[j]);
        projectile.Add(cata);
        cata.calcDistance();
    }
}