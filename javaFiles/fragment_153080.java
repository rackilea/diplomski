int __stdcall sub_4050A0(int a1)
{
  int result; // eax@1

  result = a1;
  if ( *(_BYTE *)(a1 + 12) )
  {
    result = sub_404600(*(_DWORD *)a1);
    *(_BYTE *)(a1 + 12) = 0;
  }
  return result;
}