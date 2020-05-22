import android.util.Base64
import java.security.NoSuchAlgorithmException
import javax.crypto.Cipher
import javax.crypto.NoSuchPaddingException
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

class CypherHelper {

    private var ivspec: IvParameterSpec? = null
    private var keyspec: SecretKeySpec? = null
    private var cipher: Cipher? = null
    private val ENCRYPTION_KEY: String = "1234567890123456"

    init {
        ivspec = IvParameterSpec(ENCRYPTION_KEY.toByteArray(Charsets.UTF_8))
        keyspec = SecretKeySpec(ENCRYPTION_KEY.toByteArray(), "AES")
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding")
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: NoSuchPaddingException) {
            e.printStackTrace()
        }
    }

    fun decrypt(valueToDecrypt: String): String {
        var decryptValue: String = ""
        val enc = CypherHelper()
        if (valueToDecrypt.isEmpty())
            decryptValue = String(enc.decryptInternal(valueToDecrypt)!!)

        return decryptValue
    }

    private fun decryptInternal(code: String?): ByteArray? {
        if (code == null || code.isEmpty()) {
            throw Exception("Empty string")
        }

        var decrypted: ByteArray? = null
        try {
            cipher?.init(Cipher.DECRYPT_MODE, keyspec, ivspec)
            decrypted = cipher?.doFinal(Base64.decode(code, Base64.DEFAULT))
        } catch (e: Exception) {
            throw Exception("[decrypt] " + e.message)
        }
        return decrypted
    }
}