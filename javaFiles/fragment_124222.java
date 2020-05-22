public String getLivesAsString(int lives) {
    StringBuilder sb = new StringBuilder(lives);
    for(int i = 0; i < lives; i++) {
        sb.append("♥");
    }
    return sb.toString();
}