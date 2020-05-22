// Make sure we don't access beyond the length of the array.
        if ((i + 1) < temperature.length) {
            // Is this temp less than the next one?
            if (temperature[i] < temperature[i + 1]) {
                // New max diff is next minus this.
                newMaxDiff = temperature[i + 1] - temperature[i];
            }
            // Is this temp greater than or equal to the next one?
            if (temperature[i] >= temperature[i + 1]) {
                // New max diff is this minus next.
                newMaxDiff = temperature[i] - temperature[i + 1];
            }
            // Is the new temp diff the greatest so far?
            if (maxTempDiff < newMaxDiff) {
                maxTempDiff = newMaxDiff;
                foundDay = i;
            }
        }