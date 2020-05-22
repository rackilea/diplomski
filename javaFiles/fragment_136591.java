return getUnansweredQuestionList()
        .collect(HashMap<CallServiceCode, List<CallServicePart>>::new,(hashMap, callServiceCode) -> {
            List<CallServicePart> callServiceParts = Observable.fromIterable(callServiceCode.getServicePartList())
                        .filter(s -> !s.getServicePartFormStatus().isUnanswered())
                        .toList().blockingGet();
            if (!callServiceParts.isEmpty())
                hashMap.put(callServiceCode, callServiceParts);
        }).blockingGet();