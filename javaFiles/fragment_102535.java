import java.util.*;
import java.util.regex.*;

import org.apache.commons.codec.*;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.*;

public static final Charset UTF_32BE = Charset.forName ("UTF-32BE");
public static final String REGEXP_FindTransformedEmojiHexString = "<span class=\"emoji emoji(\\p{XDigit}+)\"></span>";
public static final Pattern PATTERN_FindTransformedEmojiHexString = Pattern.compile (REGEXP_FindTransformedEmojiHexString, Pattern.CASE_INSENSITIVE);
public static String RestoreEmojiCharacters (String sContent)
{
        bMatched = true;
        String sEmojiHexString = matcher.group(1);

        Hex hex = new Hex (StandardCharsets.ISO_8859_1);
        try
        {
            for (int i=0; i<sEmojiHexString.length ();)
            {
                String sEmoji = null;
                Charset charset = null;
                String sSingleEmojiGlyphHexString = null;
                String sStartString = StringUtils.substring (sEmojiHexString, i, i+2);
                if (StringUtils.startsWithIgnoreCase (sStartString, "1f"))
                {
                    sSingleEmojiGlyphHexString = "000" + StringUtils.substring (sEmojiHexString, i, i+5);
                    i += 5;
                    charset = UTF_32BE;
                }
                else
                {
                    sSingleEmojiGlyphHexString = StringUtils.substring (sEmojiHexString, i, i+4);
                    i += 4;
                    charset = StandardCharsets.UTF_16BE;
                }
                byte[] arrayEmoji = null;
                arrayEmoji = (byte[])hex.decode (sSingleEmojiGlyphHexString);
                sEmoji = new String (arrayEmoji, charset);
                matcher.appendReplacement (sbReplace, sEmoji);
            }
        }
        catch (DecoderException e)
        {
            e.printStackTrace();
        }
    }
    matcher.appendTail (sbReplace);

    if (bMatched)
        sContent = sbReplace.toString ();

    return sContent;
}