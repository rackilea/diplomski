class Wheel {

    public static Wheel[] newWheels( int[] sizes ){
        Wheel[] result = new Wheel[sizes.length];
        for( int i=0; i < sizes.length; i++ )
           result[i] = new Wheel( sizes[i] );
        return result;
    }

    // ... other stuff ...
}