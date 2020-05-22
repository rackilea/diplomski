@Benchmark
@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public void arrayFill() {
    Arrays.fill(objectHolderForFill, null);
}

@Benchmark
@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public void arrayFillManualLoop() {
    for (int i = 0, len = objectHolderForFill.length; i < len; i++) {
        objectHolderForLoop[i] = null;
    }
}

@Benchmark
@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public void arrayCopy() {
    System.arraycopy(nullsArray, 0, objectHolderForArrayCopy, 0,
                              objectHolderForArrayCopy.length);
}

@Benchmark
@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public void directByteBufferManualLoop() {
    while (referenceHolderByteBuffer.hasRemaining()) {
        referenceHolderByteBuffer.putLong(0);
    }
}

@Benchmark
@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public void directByteBufferBatch() {
    referenceHolderByteBuffer.put(nullBytes, 0, nullBytes.length);
}

@Benchmark
@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public void directLongBufferManualLoop() {
    while (referenceHolderLongBuffer.hasRemaining()) {
        referenceHolderLongBuffer.put(0L);
    }
}

@Benchmark
@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public void directLongBufferBatch() {
    referenceHolderLongBuffer.put(nullLongs, 0, nullLongs.length);
}


@Benchmark
@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public void unsafeArrayManualLoop() {
    long addr = referenceHolderUnsafe;
    long pos = 0;
    for (int i = 0; i < size; i++) {
        unsafe.putLong(addr + pos, 0L);
        pos += 1 << 3;
    }
}

@Benchmark
@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public void unsafeArraySetMemory() {
    unsafe.setMemory(referenceHolderUnsafe, size*8, (byte) 0);
}