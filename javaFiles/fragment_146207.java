uint64_t xorshift64s (int64_t &x)
{
   x ^= x >> 12;
   x ^= x << 25;
   x ^= x >> 27;

   return x * 2685821657736338717ull;
}