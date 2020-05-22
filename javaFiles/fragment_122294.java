int[] result = new int[this.digits.length];
int carry = 0;
for(int i = this.digits.length-1; i > 0; i--) {
    int digSum = carry + this.digits[i] + that.digits[i];
    result[i] = digSum % BASE;
    carry = digSum / BASE;
}
if(carry > 0) {
    int[] temp = new int[result.length + 1];
    System.arraycopy(result, 0, temp, 1, result.length);
    temp[0] = carry;
    result = temp;
}
return new DecimalBigInt(result);