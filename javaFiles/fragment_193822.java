class MockFactoryThingie
{
   /**
    *@SuppressWarnings("unchecked")
    */
   Collection<ThingA> newThingACollection()
   { 
     return (Collection<ThingA>) ... your generic-unaware collection thing...   
   }
}