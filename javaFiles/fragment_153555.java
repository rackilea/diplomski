NSNumberFormatter *df = [[NSNumberFormatter alloc] init];

df.decimalSeparator = @".";
df.minimumFractionDigits = 1;
df.maximumFractionDigits = 5;

NSString *formattedString = [df stringFromNumber:[NSNumber numberWithDouble:areaABC+areaACD]];