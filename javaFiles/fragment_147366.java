StringJoiner sj = new StringJoiner(",");

while (minValue <= maxValue)
{
    sj.add( "" + minValue);
    minValue++;
}

valueOutput.setText( sj.toString() );