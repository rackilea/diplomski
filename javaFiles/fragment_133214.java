private static final int SPECIAL_MASK = 0x000000F0;

int specialValue = valueAsInt & SPECIAL_MASK;
int nonSpecialBits = valueAsInt & ~SPECIAL_MASK;
for (TestEnum testEnum : TestEnum.values()) 
{
    int value = testEnum.getValue();
    if( (value & SPECIAL_MASK) != 0 )
        continue; //this is one of the special values; ignore.
    if( (value & nonSpecialBits) == value )
        collection.add( testEnum );
}