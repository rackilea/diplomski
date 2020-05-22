char c = 'C';
for (int i = 0; i < 8; ++i)
{
  // extract the i-th bit
  int b = ((c & 1<<i) >> i);
  // b will be 1 if i-th bit is set, 0 otherwise

  // do whatever you want with b
}