public boolean compareSeverity(Patient other) {
    boolean result = false;
    if((other.severity > severity) || (other.severity == severity && other.arrival < arrival)) {
        result = true;
    }
    return result;
}