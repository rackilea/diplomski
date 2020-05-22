for(String fsgr : splited_game_result) {

    String fsgrTrim = fsgr.trim();

    if (!fsgrTrim.isEmpty()) {
        final_result[g] = Integer.parseInt(fsgrTrim);
        g++;
    }
}