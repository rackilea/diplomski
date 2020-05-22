public String breakCaesarCipher(String input) {
    String in_0 = halfOfString(input, 0);
    String in_1 = halfOfString(input, 1);
    // Find first key
    // Determine character frequencies in ciphertext
    int[] freqs_0 = countOccurrencesOfLetters(in_0);
    // Get the most common character
    int freqDex_0 = maxIndex(freqs_0);
    // Calculate key such that 'E' would be mapped to the most common ciphertext character
    // since 'E' is expected to be the most common plaintext character
    int dkey_0 = freqDex_0 - 4;
    // Make sure our key is non-negative
    if (dkey_0 < 0) {
        dkey_0 = dkey_0+26;
    }
    // Find second key
    int[] freqs_1 = countOccurrencesOfLetters(in_1);
    int freqDex_1 = maxIndex(freqs_1);
    int dkey_1 = freqDex_1 - 4;
    if (freqDex_1 < 4) {
        dkey_1 = dkey_1+26;
    }

    CaesarCipherTwoKeys cctk = new CaesarCipherTwoKeys(dkey_0, dkey_1);
    return cctk.decrypt(input);
}