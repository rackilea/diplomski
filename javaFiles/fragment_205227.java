public class StSongProvider extends XMLWorkerFontProvider {

  private static final Logger LOG = LoggerFactory.getLogger(StSongProvider.class);

  public StSongProvider() {
    super(null, null);
  }

  @Override
  public Font getFont(final String fontName, String encoding, float size, final int style) {
    BaseFont font = null;
    try {
      if (StringUtils.equals(fontName, "STSong-Light")) {
        font = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
      } else {
        font = BaseFont.createFont(FontFactory.TIMES_ROMAN, FontFactory.defaultEncoding, true);
      }
    } catch (Exception e) {
      // do something
    }
    return new Font(font, size, style);
  }

}