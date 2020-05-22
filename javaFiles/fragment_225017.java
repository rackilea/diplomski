int x = 3;
int res = x++ + ++x + x++
// res = (x++) + (++x) + (x++) with x = 3
// res =   3   + (++x) + (x++) with x = 4
// res =   3   +   5   + (x++) with x = 5
// res =   3   +   5   +   5   with x = 6
// res = 13