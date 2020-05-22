int getLast( double value )
{
  int rc;
  char buf[64];
  rc=snprintf(buf,64,"%f",value);
  // TODO:: check rc is in the range 1-64 
  return buf[rc-1]-'0';
}