for(Annotation a : injectionPoint.getQualifiers())
{
   if(a instanseof MyCar)
   {
     MyCar myCar = (MyCar) a;
     a.mpg();
   }
}