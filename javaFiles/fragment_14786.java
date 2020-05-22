public String show() {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i <= tablica.length; i++) {
        for (int j = 0; j <= tablica.length[i]; j++) {
            result.append(String.format("%7.2f ", tablica[i][j]));
        }
        result.append("\n");
    }

    return result.toString();
}