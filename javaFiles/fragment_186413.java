MyClass x = ar[3].equals("month") ? new MyClassMonth() :
            (ar[3].equals("year") ? new MyClassYear() :
            (ar[3].equals("week") ? new MyClassWeek() :
            (ar[3].equals("half-year") ? new MyClassHalfyear() :
                                        new MyClassQuarter())));
x.doSomething();