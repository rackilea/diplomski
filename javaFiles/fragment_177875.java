enum LetterGroup {
    A_E, F_J, K_O, P_T, U_Z;
    public static LetterGroup of(String s) {
        char ch = Character.toUpperCase(s.charAt(0));
        if (ch >= 'A' && ch <= 'E') return A_E;
        if (ch >= 'F' && ch <= 'J') return F_J;
        if (ch >= 'K' && ch <= 'O') return K_O;
        if (ch >= 'P' && ch <= 'T') return P_T;
        if (ch >= 'U' && ch <= 'Z') return U_Z;
        throw new IllegalArgumentException(s);
    }
}