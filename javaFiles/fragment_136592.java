return getUnansweredQuestionList()
           .collect(HashMap<CallServiceCode, List<CallServicePart>>::new, (hashMap, callServiceCode) -> {
               List<CallServicePart> filteredParts = getFilteredServiceParts(callServiceCode.getServicePartList());
               if (!filteredParts .isEmpty())
                   hashMap.put(callServiceCode, filteredParts);
            }).blockingGet();