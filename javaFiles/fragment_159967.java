DataBufferInt bufferA = (DataBufferInt)imageA.getRaster().getDataBuffer();
DataBufferInt bufferB = (DataBufferInt)imageB.getRaster().getDataBuffer();
int arrayA[] = bufferA.getData();
int arrayB[] = bufferB.getData();
if (Arrays.equal(arrayA, arrayB))
{
    // Images are equal!
}