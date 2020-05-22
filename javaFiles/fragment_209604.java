Projection ms = expression("$millisecond", projection("timestamp"));
    Projection secToMs = multiply(expression("$second", projection("timestamp")), SEC_TO_MS);
    Projection minToMs = multiply(expression("$minute", projection("timestamp")), MIN_TO_MS);
    Projection hourToMs = multiply(expression("$hour", projection("timestamp")), H_TO_MS);
    Projection sum = add(ms, secToMs, minToMs, hourToMs);
    Projection dayRounded = subtract(projection("timestamp"), sum);