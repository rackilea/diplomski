public boolean voegDeelnameToe(String deelnemer, String[] aanwezigheden) {
    if (index < poll.length && index < deelnemers.length) {
        deelnemers[index] = deelnemer;
        System.arraycopy(aanwezigheden, 0, poll[index], 0, aanwezigheden.length);
        ++index;
    }
    return type;
}