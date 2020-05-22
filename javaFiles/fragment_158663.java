fun base64SafeDecoder(encoded: String): ByteArray {
    val decoder = if (encoded.endsWith('=') || encoded.any { it == '+' || it == '/' }) {
        Base64.getDecoder()
    }
    else {
        Base64.getUrlDecoder()
    }
    return decoder.decode(encoded.toByteArray())
}