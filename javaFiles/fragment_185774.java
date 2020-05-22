Gate gate1 = new Gate("gate5", 23);
        gateRepository.save(gate1);

        Threshold threshold1 = new Threshold(101, "threshold5");
        thresholdRepository.save(threshold1);

        Set<Gate> gates = new HashSet<>();
        gates.add(gate1);

        Set<Threshold> thresholds = new HashSet<>();
        thresholds.add(threshold1);