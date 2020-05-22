ByteBuffer buffer = ByteBuffer.allocateDirect(size);
Pointer dataPtr = adapter.GetData1();
long destAddress = ((DirectBuffer)buffer).address();
Pointer destPtr = AsmRuntime.pointerValue(destAddress, runtime);

assert dataPtr.isDirect() && destPtr.isDirect();

dataPtr.transferTo(0, destPtr, 0, size);