public class ObserverTest {

    @Test
    public void testAnything() {
        Observable1 obsrvable1 = new Observable1();
        Observable2 obsrvable2 = new Observable2();

        Observer obsrvr = new Observer();
        obsrvable1.addObserver(obsrvr, new ObserverVisitor1());
        obsrvable2.addObserver(obsrvr, new ObserverVisitor2());

        obsrvable1.changeSomething();
        obsrvable2.changeSomething();
    }

}