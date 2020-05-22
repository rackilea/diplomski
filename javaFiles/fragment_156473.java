public class RingBuffer 
{
    private double[] emptyBuffer;

    public RingBuffer(int capacity){
        emptyBuffer = new double[capacity];
        System.out.print(EmptyBuffer.length);
    }

    public int size(){
        int size = emptyBuffer.length;
        return size;
    }
}