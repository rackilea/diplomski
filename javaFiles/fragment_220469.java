public static boolean nvm(boolean[] con) {
    for(int i = 0; i < con.length ; i++) {
        if (!con[i]) return false;
    }

    return true;
}