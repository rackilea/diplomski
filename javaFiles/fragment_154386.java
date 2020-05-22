public void foo() {
    Long[] gData = new Long[] { 1L, 2L };

    rx.Observable.from(gData)
    .concatMap(data -> {

        rx.Observable<GmObject> depositObs1 = depositToUserBalance(data, 1).doOnNext(obj -> obj.putNumber("seat_index", data));
        rx.Observable<GmObject> depositObs2 = depositToUserBalance(data, 2).doOnNext(obj -> obj.putNumber("seat_index", data));


        return rx.Observable.merge(depositObs1, depositObs2);
    })
   .reduce(new ArrayList<Long>(), (payoutArr, payoutObj) -> {

        int seatIndex = ((GmObject) payoutObj).getNumber("seat_index").intValue();
        long payout = ((GmObject) payoutObj).getNumber("payout").longValue();
        payoutArr.add(seatIndex, payout);
        return payoutArr;
   })
   .subscribe(results -> System.out.println(results));
}