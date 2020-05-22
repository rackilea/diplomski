List<CommissionSchedule> commissionSched = 
    commissionScheduleRepository.findByCarrier(carrier);

List<String> hs = commisionSched.stream()
                        .map(cs -> cs.getHs())
                        .collect(Collectors.toList());