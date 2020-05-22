for (int i=0; i<allEntities.size(); i++)
{ 
    for (int j=i+1; j<allEntities.size(); j++)
    {
        Entity ei = allEntities.get(i);
        Entity ej = allEntities.get(j);
        if (ei.collides(ej)) handleCollision();
    }
}