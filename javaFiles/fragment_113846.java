Observable<List<Cal>> cal = Calbackend.get(customerid).toList();
Observable<List<Erp>> erp = ERPbackend.get(customerid).toList();
Observable<List<Help>> help = Helpbackend.get(customerid).toList();
Observable<List<Crm>> crm = CRMbackend.get(customerid).toList();
Observable.zip(cal, erp, help, crm,
                new Func4<List<Cal>, List<Erp>, List<Help>, List<Crm>, Result>() {
                    @Override
                    public Result call(List<Cal> cals, List<Erp> erps, List<Help> helps, List<Crm> crms) {
                        Result myResult = new Result();
                        // add all cals, erps, helps and crms to result
                        return myResult;
                    }
                })
                .subscribe(new Subscriber<Result>() {
                    @Override
                    public void onNext(Result result) {
                        // do something with the result
                    }

                    ...
                });