foreach (Enemy e in EnemyCollection)
{
    Rectangle r = new Rectangle(e.X,e.Y,e.Width,e.Height);
    Rectangle p = new Rectangle(player.X,player.Y,player.Width,player.Height);

    // Assuming there is an intersect method, otherwise just handcompare the values
    if (r.Intersects(p))
    {
       // A Collision!
       // we know which enemy (e), so we can call e.DoCollision();
       e.DoCollision();
    }
}