Map<Integer, BigInteger> acceptedDetailMapping = Arrays.stream(acceptedDetails)
        .collect(Collectors.toMap(a -> extractEmployeeId.apply(a.getId()),
                a -> extractDate.apply(a.getId())));

Map<Integer, BigInteger> rejectedDetailMapping = Arrays.stream(rejectedDetails)
        .collect(Collectors.toMap(a -> extractEmployeeId.apply(a.getAd().getId()),
                a -> extractDate.apply(a.getAd().getId())));