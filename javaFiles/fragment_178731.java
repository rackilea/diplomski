public class Types {
     public boolean equals( Object obj ) {
        // something
     }

     public boolean equals( String str ) {
        return false;
     }
}

public class Main {

    public static void main(String[] args) {
       Object typ = new Types();
       System.out.println( typ.equals("foo" ) );
    }
}