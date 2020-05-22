public class Rizze_debug_Rxjava_Test extends METRICS_JUNIT {

    @Test
    public void testR2_JEOR() {

        logger.info("trace 1 ");
        Observable<String> obs = Observable.create((Subscriber<? super String> s) -> {
            try {

                logger.info("//processsing");
                Request.add();
            } catch (Exception e) {
                e.printStackTrace();
                s.onError(e);
            }

            logger.info("//done");
            s.onNext("done");
            s.onCompleted();
        });
        logger.info("trace 2");
        obs.subscribeOn(Schedulers.io()).subscribe();

        assertEquals(1, Request.i);
        logger.info("trace 3");
    }

    public static class Request {
        public static int i = 0;

        public static void add() {
            i++;
        }
    }
}