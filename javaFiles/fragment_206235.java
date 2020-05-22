public static void main(final String... args)
            throws IOException {
        final Iterable<ITest> tests = ImmutableList.of(
                FirstTest.get(),
                ReadAsWholeListTest.get(),
                ReadAsWholeTreeSetTest.get(),
                ReadJsonStreamIntoListTest.get(),
                ReadJsonStreamIntoTreeSetTest.get(),
                ReadJsonStreamIntoListChunksTest.get()
        );
        for ( int i = 0; i < 3; i++ ) {
            for ( final ITest test : tests ) {
                try ( final ZipInputStream zipInputStream = new ZipInputStream(Resources.getPackageResourceInputStream(Q49273660.class, "cities.json.zip")) ) {
                    for ( ZipEntry zipEntry = zipInputStream.getNextEntry(); zipEntry != null; zipEntry = zipInputStream.getNextEntry() ) {
                        if ( zipEntry.getName().equals("cities.json") ) {
                            final JsonReader jsonReader = new JsonReader(new InputStreamReader(zipInputStream)); // do not close
                            System.out.printf("%1$35s : ", test.getName());
                            final Stopwatch stopwatch = Stopwatch.createStarted();
                            final Collection<City> cities = test.test(jsonReader);
                            System.out.printf("in %d ms with %d elements\n", stopwatch.elapsed(TimeUnit.MILLISECONDS), cities.size());
                            assertSorted(cities, City::compareByName);
                        }
                    }
                }
            }
            System.out.println("--------------------");
        }
    }

    private static <E> void assertSorted(final Iterable<? extends E> iterable, final Comparator<? super E> comparator) {
        final Iterator<? extends E> iterator = iterable.iterator();
        if ( !iterator.hasNext() ) {
            return;
        }
        E a = iterator.next();
        if ( !iterator.hasNext() ) {
            return;
        }
        do {
            final E b = iterator.next();
            if ( comparator.compare(a, b) > 0 ) {
                throw new AssertionError(a + " " + b);
            }
            a = b;
        } while ( iterator.hasNext() );
    }