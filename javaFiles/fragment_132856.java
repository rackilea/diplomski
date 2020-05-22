public boolean equals(Object other) {
        if(this == other)
            return true;

        if (!(other instanceof Pair)) {
            return false;
        }


        Pair<?, ?> otherPair = (Pair<?, ?>) other;

        return Equality.equals(this.first,otherPair._first) &&
               Equality.equals(this._second, otherPair._second);
    }


    class Equality{
         public static boolean equals(Object first, Object second){ 
              return first == null ? second == null : first.equals(second);
         }
    }