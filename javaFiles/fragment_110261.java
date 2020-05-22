for(String fsgr : splited_game_result) {
    try {
        final_result[g] = Integer.parseInt(fsgr);
        g++;
    } catch (Exception e) {
        e.printStackTrace();
    }
}