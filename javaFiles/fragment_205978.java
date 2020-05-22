struct ntptimeval
{
  struct timeval time;  /* current time (ro) */
  long int maxerror;    /* maximum error (us) (ro) */
  long int esterror;    /* estimated error (us) (ro) */
  long int tai;     /* TAI offset (ro) */

  long int __glibc_reserved1;
  long int __glibc_reserved2;
  long int __glibc_reserved3;
  long int __glibc_reserved4;
};