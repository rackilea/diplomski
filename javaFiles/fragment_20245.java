public static enum MyEnum {
    KWH(1300), 
    Diagnostic(1100),
    ReadType3(1400, 1401);

    private Set<Integer> timTagNumbers;

    MyEnum(Integer... timTagNumbers) {
        this.timTagNumbers = new HashSet<Integer>(Arrays.asList(timTagNumbers));
        //add check to make sure that values are unique across all instances
    }

    public static MyEnum forTIMTagNumber(int num) {
        for ( MyEnum readType : values() ) {
             if ( readType.timTagNumbers.contains(num) ) {
                 return readType;
             }
        }
        throw new NoSuchElementException("No ReadType matching TIMTagNumber " + num);
    }
}

//...
int timTagNumber = 1400;
ReadType readType = ReadType.forTIMTagNumber(timTagNumber);