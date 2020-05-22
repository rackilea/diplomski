- (int)checkDataAuxAccountNumber:(NSString *)auxAccountNumber pCounter:(int)pCounter digitIndex:(int)digitIndex {
    NSString *digitString = [auxAccountNumber substringWithRange:NSMakeRange(digitIndex, 1)];
    int digit = [digitString intValue];

    if (digitIndex % 2 == 0) {
        digit *= 2;
        if (digit >= 10) {
            digit -= 9;
        }
    }

    return pCounter + digit;
}