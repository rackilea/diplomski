#pragma version(1)
#pragma rs java_package_name(com.mypackage)
#pragma rs_fp_relaxed

int32_t count = 0;
rs_allocation rsAllocationCount;

void countPixels(uchar4* unused, uint x, uint y) {
  rsAtomicInc(&count);
  rsSetElementAt_int(rsAllocationCount, count, 0);
}