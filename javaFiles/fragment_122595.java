boolean shouldPerform() {
    if (group != G1) {
        return true;
    }
    if (role != R1) {
        return false;
    }
    if (level > 2) {
        return false;
    }
    if (class == C1) {
        return true;
    }
    if (level != 1) {
        return false;
    }
    return class == C2 || class == C3;
}