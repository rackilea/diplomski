public int compareTo(Letter that) 
{
  if (this.toAddress == null) {
    if (that == null || that.toAddress == null) {
      return 0;
    }
    return -1;
  }
  if (that == null) return 1; // <-- Add something like this.
  // int value;
  // value = this.toAddress.getZip().compareTo(that.toAddress.getZip());
  return this.toAddress.getZip().compareTo(that.toAddress.getZip());
}