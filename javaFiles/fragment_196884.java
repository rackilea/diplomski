2938       public static int hashCode(int a[]) {
 2939           if (a == null)
 2940               return 0;
 2941   
 2942           int result = 1;
 2943           for (int element : a)
 2944               result = 31 * result + element;
 2945   
 2946           return result;
 2947       }