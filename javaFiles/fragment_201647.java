public enum Stat { FOO, BAR }

    public class Controller
    {
        private Subject<Stat> statSubject;

        public Controller()
        {
            statSubject = BehaviorSubject.<Stat>create().toSerialized();
        }

        public Observable<Stat> getStatChange()
        {
            return statSubject.distinctUntilChanged();
        }

        public void setStat( Stat stat )
        {
            statSubject.onNext( stat );
        }
    }

    public class Measurer
    {
        public Measurer( Controller controller )
        {
            Observable.timer( 1, TimeUnit.SECONDS, Schedulers.newThread() )
                .repeat()
                .withLatestFrom(
                        controller.getStatChange(),
                        ( __, stat ) -> stat ) // ignore the Long emitted by timer
                .subscribe( this::measureStat );
        }

        private void measureStat( Stat stat )
        {
            switch( stat )
            {
            case FOO:
                measureFoo();
                break;

            default:
                measureBar();
                break;
            }
        }

        private void measureBar()
        {
            System.out.println( "Measuring Bar" );
        }

        private void measureFoo()
        {
            System.out.println( "Measuring Foo" );
        }
    }

    @Test
    public void testMeasureStats() throws InterruptedException
    {
        Controller controller = new Controller();
        controller.setStat( Stat.BAR );

        @SuppressWarnings( "unused" )
        Measurer measurer = new Measurer( controller );

        Thread.sleep( 5000 );

        controller.setStat( Stat.FOO );

        Thread.sleep( 5000 );

        controller.setStat( Stat.BAR );

        Thread.sleep( 5000 );
    }