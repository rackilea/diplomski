for (int i = idx * batchSize; i < upper; i++) {
    diff = Math.abs(data.solution[i] - data.x[i]); // Calculate
        // convergence
        if (diff > localNorm)
            localNorm = diff;
            data.x[i] = data.solution[i];
        }
}