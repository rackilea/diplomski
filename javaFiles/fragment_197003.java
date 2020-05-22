import org.jitsi.impl.neomedia.codec.FFmpeg;

public class MyFFmpeg extends FFmpeg {
    // 1 enums past mp3
    public static final int CODEC_ID_AAC = FFmpeg.CODEC_ID_MP3 + 1;
    // 48 enums past mp3
    public static final int CODEC_ID_AAC_LATM = FFmpeg.CODEC_ID_MP3 + 48;

    public static void main(String[] args) {
        // expect 86018 and 86065
        System.out.println("AAC: " + CODEC_ID_AAC + ' ' + CODEC_ID_AAC_LATM);
    }
}