func decode(data string) (string, error) {
    ciphertext, err := base64.StdEncoding.Decode(data)
    if err != nil {
        return "", err
    }

    c, err := aes.NewCipher([]byte(DECODE_KEY))
    if err != nil {
        return "", err
    }

    result := make([]byte, len(ciphertext))
    for i := 0; i < len(ciphertext); i += aes.BlockSize {
        c.Decrypt(result[i:], ciphertext[i:])
    }

    return string(result), nil
}