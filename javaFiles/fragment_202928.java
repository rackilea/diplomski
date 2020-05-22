public abstract class Ordering<X>
{
abstract boolean isLower(X a, X b);
abstract boolean isEquals(X a, X b);
   final boolean isGreater(X a, X b) {
      return !isLower(a, b) && !isEquals(a, b);
   }
}