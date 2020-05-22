public float dot(MyVector v) throws Exception
{
   if( (start.x != v.start.x) || (start.y != v.start.y))
        throw new Exception("Vectors not begin in same Point");

   return unchecked_dot(MyVector v)
}