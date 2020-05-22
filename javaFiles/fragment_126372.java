/// Intel's optimization manual
  /// Example 2-2. Contended Locks with Increasing Back-off Example

  /// from section 2.2.4 Pause Latency in Skylake Microarchitecture
  /// (~140 cycles, up from ~10 in Broadwell, thus max backoff should be shorter)
/*******************/
/*Baseline Version */
/*******************/
// atomic {if (lock == free) then change lock state to busy}
while (cmpxchg(lock, free, busy) == fail)
{
   while (lock == busy)
     _mm_pause();
}


/*******************/
/*Improved Version */
/*******************/
int mask = 1;
int const max = 64; //MAX_BACKOFF
while (cmpxchg(lock, free, busy) == fail)
{
   while (lock == busy)
   {
      for (int i=mask; i; --i){
         _mm_pause();
      }
      mask = mask < max ? mask<<1 : max;    // mask <<= 1  up to a max
   }
}