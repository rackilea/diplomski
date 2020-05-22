Optional<StopChkRecType> findFirst = ifxStopChkInqRs.getBankSvcRs()
        .stream()
        .flatMap(b -> b.getStopChkInqRs().stream())
        .flatMap(i -> i.getStopChkRec().stream())
        .filter(d -> d.getStopChkInfo().getDesc().equals("D"))
        .findFirst();