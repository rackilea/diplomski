public class Test {
    public static class ArrTest<E>
    {
        public void test(E a){
            E[] b = (E[])new Object[1];
            b[0] = a;
            System.out.println(b[0]);
        }
        public E[] test2(E a){
            E[] b = (E[])new Object[1];
            b[0] = a;
            System.out.println(b[0]+" "+b.getClass().getComponentType());
            return b;
        }
        public static void main(String[] args){
            ArrTest<String> t = new ArrTest<String>();
            t.test("Hello World");
            try{String[] result = t.test2("Hello World");}catch(Exception e){System.out.println(e);}
        }
    }

    public static void main(String[] args) {
        ArrTest.main(args);

        System.out.println("#############\nWe want an array that stores only integers, sampledata: 1, samplearray: Integer");
        test(new ExampleType<Integer>(Integer.class), 1, new Integer[0], new Integer[10]);

        System.out.println("#############\nWe want an array that stores any type of Number, sampledata: 2L, samplearray: Number");
        test(new ExampleType<Number>(Number.class), 2L, new Number[0], new Number[10]);

        System.out.println("#############\nWe want an array that stores any type of CustomNumberA, sampledata: CustomB(3L), samplearray: CustomNumberA");
        test(new ExampleType<CustomNumberA>(CustomNumberA.class), new CustomNumberB(3L), new CustomNumberA[0], new CustomNumberA[10]);

        System.out.println("#############\nWe want A to be any type of number but we want to create an array of CustomNumberA, sampledata: CustomB(3L), samplearray: CustomNumberA");
        test(new ExampleType<Number>(Number.class), new CustomNumberB(3L), new CustomNumberA[0], new CustomNumberA[10]);
    }

    public static <A extends Number> void test(ExampleType<A> testType, A sampleData, A[] smallSampleArray, A[] bigSampleArray)
    {
        Class<A> clazz = testType.clazz;
        System.out.println("#############\nStarting tests with ExampleType<"+clazz.getSimpleName()+">");
        System.out.println("============\nCreating with badMethod()...");
        A[] array;
        try
        {
            array = testType.badMethod();
            testType.executeTests(array);
        }
        catch(Exception e){ System.out.println(">> ERR: "+e); }
        System.out.println("============\nCreating with alsoBadMethod("+sampleData+" ["+sampleData.getClass().getSimpleName()+"])...");
        try
        {
            array = testType.alsoBadMethod(sampleData);
            testType.executeTests(array);
        }
        catch(Exception e){ System.out.println(">> ERR: "+e); }
        System.out.println("============\nCreating with nearlyGoodMethod("+smallSampleArray.getClass().getSimpleName()+" len: "+smallSampleArray.length+")...");
        try
        {
            array = testType.nearlyGoodMethod(smallSampleArray);
            testType.executeTests(array);
        }
        catch(Exception e){ System.out.println(">> ERR: "+e); }
        System.out.println("============\nCreating with nearlyGoodMethod("+bigSampleArray.getClass().getSimpleName()+" len: "+bigSampleArray.length+")...");
        try
        {
            array = testType.nearlyGoodMethod(bigSampleArray);
            testType.executeTests(array);
        }
        catch(Exception e){ System.out.println(">> ERR: "+e); }
        System.out.println("============\nCreating with bestMethod("+smallSampleArray.getClass().getSimpleName()+" len: "+smallSampleArray.length+")...");
        try
        {
            array = testType.bestMethod(smallSampleArray);
            testType.executeTests(array);
        }
        catch(Exception e){ System.out.println(">> ERR: "+e); }
        System.out.println("============\nCreating with bestMethod("+bigSampleArray.getClass().getSimpleName()+" len: "+bigSampleArray.length+")...");
        try
        {
            array = testType.bestMethod(bigSampleArray);
            testType.executeTests(array);
        }
        catch(Exception e){ System.out.println(">> ERR: "+e); }
    }

    @RequiredArgsConstructor @ToString()
    public static class CustomNumberA extends Number{
        @Delegate final Long n;
    }

    public static class CustomNumberB extends CustomNumberA{
        public CustomNumberB(Long n) { super(n); }
    }

    @RequiredArgsConstructor
    public static class ExampleType<A>{
        private int testSize = 7;
        final Class<A> clazz;

        public A[] badMethod()
        {
            System.out.println("This will throw a ClassCastException when trying to return the array because Object is not a type of "+clazz.getSimpleName());
            A[] array = (A[]) new Object[testSize]; //Warning: Type safety: Unchecked cast from Object[] to A[]
            System.out.println("Array of "+array.getClass().getComponentType()+" created");
            return array;
        }

        public A[] alsoBadMethod(A sampleType)
        {
            System.out.println("Will not respect A type ("+clazz.getSimpleName()+"), will always use the highest type in sampleType and tell that it's A[] but it's not, in this case will return "+sampleType.getClass().getSimpleName()+"[] and said it was "+clazz.getSimpleName()+"[] while developing");
            A[] array = (A[]) Array.newInstance(sampleType.getClass(), testSize); //Type safety: Unchecked cast from Object to A[]
            return array;
        }

        public A[] nearlyGoodMethod(A[] array)
        {
            System.out.println("The only guarantee is that the returned array will be of something that extends A ("+clazz.getSimpleName()+") so the returned type is not clear, may be of A or of the type passed in the argument but will tell it's A[] but may not be");
            if(array.length < testSize)
                array = (A[]) Array.newInstance(array.getClass().getComponentType(), testSize); //Type safety: Unchecked cast from Object to A[]
            System.out.println("in this case: "+array.getClass().getComponentType().getSimpleName()+"[], expecting: "+clazz.getSimpleName()+"[]");
            return array;
        }

        public <T extends A> T[] bestMethod(T[] array)
        {
            System.out.println("It's guaranteed to return on array of the same type as the sample array and it must be an instance of A, so, this is the best method");
            if(array.length < testSize)
                array = (T[]) Array.newInstance(array.getClass().getComponentType(), testSize); //Type safety: Unchecked cast from Object to T[]
            System.out.println("in this case: "+array.getClass().getComponentType().getSimpleName()+"[], expecting: "+array.getClass().getComponentType().getSimpleName()+"[]");
            return array;
        }

        public void executeTests(A[] array)
        {
            tryToSet(array, 0, 1);
            tryToSet(array, 1, 2L);
            tryToSet(array, 2, 3.1);
            tryToSet(array, 3, 4F);
            tryToSet(array, 4, (byte)0x5);
            tryToSet(array, 5, new CustomNumberA(6L));
            tryToSet(array, 6, new CustomNumberB(7L));
        }

        public void tryToSet(A[] array, int index, Object value)
        {
            System.out.println("Trying to set "+value+" ("+value.getClass().getSimpleName()+") at "+index+" in a array of "+array.getClass().getComponentType().getSimpleName());
            try
            {
                if(array instanceof Object[]) ((Object[]) array)[index] = value;
                else array[index] = (A) value; //Type safety: Unchecked cast from Object to A
                System.out.println("## OK: Success: "+array.getClass().getComponentType().getSimpleName()+"["+index+"] = "+array[index]);
            }
            catch(Exception e){ System.out.println(">> ERR: "+e); }
        }
    }
}