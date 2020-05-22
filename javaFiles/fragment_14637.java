for (int i = OSR_value; i != 0; i++) {
    if (1 % i == 0) {
        uncommon_trap();
    }
}
uncommon_trap();