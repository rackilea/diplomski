static Terrain getTerrainFor(int val)
{
   for (Terrain t : Terrain.values())
   {
      if (t.value() == val)
         return t;
   }

   return t;
}