List<Call> sampleCalls = List.of(new Call(CallStatus.SUCCESS,"naman"),new Call(CallStatus.FAILED,"naman"),
        new Call(CallStatus.SUCCESS,"diego"), new Call(CallStatus.FAILED,"diego"), new Call(CallStatus.SUCCESS,"diego"));

Map<String, Map<CallStatus, Long>> groupedMap = sampleCalls.stream()
        .collect(Collectors.groupingBy(Call::getCallName,
                Collectors.groupingBy(Call::getStatus, Collectors.counting())));