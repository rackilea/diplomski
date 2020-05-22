public class Vector3D extends Vector {
    @Override
    public boolean Compare(Vector vec){
        if( !(vec instanceof Vector3D) )
            throw new IllegalArgumentException("Vector3D can only be compared to Vector3D!");

        // Compare and return true or false
    }
}