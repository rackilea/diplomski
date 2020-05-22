ByteBuffer buffer = ByteBuffer.allocateDirect(size);
Data outData = new Data(runtime);
adapter.GetData2(outData);

Pointer dataPtr = outData.data.get();
long destAddress = ((DirectBuffer)buffer).address();
Pointer destPtr = AsmRuntime.pointerValue(destAddress, runtime);

assert dataPtr.isDirect() && destPtr.isDirect();

dataPtr.transferTo(0, destPtr, 0, size);