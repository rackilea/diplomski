final class Key{
     int a , b , c;
     public Key(int a , int b , int c){
         this.a = a;
         this.b = b;
         this.c = c;
     }

     public int hashCode(){
          return (a << 10 ^ b << 5 ^ c);
     }

     public boolean equals(Object o){
          if(!(o instanceof Key))
               return false;

          Key k = (Key) o;

          return (k.a == a && k.b == b && k.c == c);
     }
}