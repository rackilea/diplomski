import com.google.auth.oauth2.ServiceAccountCredentials
import com.google.cloud.translate.Translate
import com.google.cloud.translate.TranslateOptions
import java.io.FileInputStream

class StringsTranslator {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val translate = TranslateOptions.newBuilder().setCredentials(ServiceAccountCredentials.fromStream(
                    FileInputStream("ktools/google-apis-credentials.json")
            )).build().service

            val text = "Hello world!"
            val translation = translate.translate(
                    text,
                    Translate.TranslateOption.sourceLanguage("en"),
                    Translate.TranslateOption.targetLanguage("es")
            )

            println("$text = ${translation.translatedText}")
        }
    }
}