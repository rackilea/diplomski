List<DispatchSMSQ> blockedNumbers = messagePermissionResponseDTOList.stream()
    .filter(MessagePermissionResponseDTO::isBlocked)
    .map(MessagePermissionResponseDTO::getPhoneNumber)
    .collect(Collectors.collectingAndThen(Collectors.toSet(), 
        s -> dispatchSMSQList.stream()
            .filter(d -> s.contains(d.getMdn())).collect(Collectors.toList())));