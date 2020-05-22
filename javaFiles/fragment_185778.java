double getRain(String state) {
    for (int i = 0; i < num_state; i++) {
        if (states[i].equals(state)) {
            return rainAmt[i];
        }
    }
    return -1;
}

// Just a toString() method for convenience
@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < num_state; i++) {
        sb.append("Rainfall for ").append(states[i]).append(" is: ").append(rainAmt[i]);
    }
    return sb.toString();
}