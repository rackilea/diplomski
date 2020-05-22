byte readMemory(int address) 
{
  if ((address & 0xFF000000) == 0xFF000000)
    return ioPorts.read(address);

  // remove most significative nibble, we don't need it
  address &= 0x0FFFFFFF;

  // 0xF000000 zone
  // according to bios rom size you could need a different kind of comparison since it may wrap over 0xFFFFFFF
  if ((address & 0xF000000) == 0xF000000)
  {
    // now your address space is just from 0xF000000 to 0xFC00000 + size of BIOS ROM (4mb max?)
  }
  else
  {
    // we don't know if you map bios together with ram or separately
    return mainRam.readMemory(address);
  }
}