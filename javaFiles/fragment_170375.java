public class RxHelper {

    public static <T1, T2, R> Observable<R> flatZip(Observable<? extends T1> o1, Observable<? extends T2> o2, final Func2<? super T1, ? super T2, Observable<? extends R>> zipFunction) {
        return Observable.merge(Observable.zip(o1, o2, zipFunction));
    }

    public static <T1, T2, T3, R> Observable<R> flatZip(Observable<? extends T1> o1, Observable<? extends T2> o2, Observable<? extends T3> o3, Func3<? super T1, ? super T2, ? super T3, Observable<? extends R>> zipFunction) {
        return Observable.merge(Observable.zip(o1, o2, o3, zipFunction));
    }

    public static <T1, T2, T3, T4, R> Observable<R> flatZip(Observable<? extends T1> o1, Observable<? extends T2> o2, Observable<? extends T3> o3, Observable<? extends T4> o4, Func4<? super T1, ? super T2, ? super T3, ? super T4, Observable<? extends R>> zipFunction) {
        return Observable.merge(Observable.zip(o1, o2, o3, o4, zipFunction));
    }
}