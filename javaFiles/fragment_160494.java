builder.newClass{

    loader this.class.classLoader

    name 'MyClass'

    [Calendar, UUID, Random].each { imports it }

    fields 'field1' : Integer,
           'field2' : Integer

    methods 'sum' : {return field1 + field2},
            'product' : {return field1 * field2},
            'testCalendar' : {return Calendar.getInstance().getTime()},
            'testRandom' : {return (new Random()).nextInt()}

}