{
  auto tempTapPtr=TapPtr;
  ++TapPtr;
  Tap[tempTapPtr]=Inp[i];
  Sum+=Tap[tempTapPtr];
}
Out[i]=Sum;