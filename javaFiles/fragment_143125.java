import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
public class CharsetToolkit{
private byte[] buffer;
private Charset defaultCharset;
private boolean enforce8Bit = false;
public CharsetToolkit(byte[] buffer)
{
    this.buffer = buffer;
    this.defaultCharset = getDefaultSystemCharset();
}
public CharsetToolkit(byte[] buffer, Charset defaultCharset)
{
    this.buffer = buffer;
    setDefaultCharset(defaultCharset);
}
public void setDefaultCharset(Charset defaultCharset)
{
    if (defaultCharset != null)
        this.defaultCharset = defaultCharset;
    else
        this.defaultCharset = getDefaultSystemCharset();
}
public void setEnforce8Bit(boolean enforce)

{

    this.enforce8Bit = enforce;

}

public boolean getEnforce8Bit()

{

    return this.enforce8Bit;

}

public Charset getDefaultCharset()
{
    return defaultCharset;
}

public Charset guessEncoding()
{
    if (hasUTF8Bom(buffer)) return Charset.forName("UTF-8");
    if (hasUTF16LEBom(buffer)) return Charset.forName("UTF-16LE");
if (hasUTF16BEBom(buffer)) return Charset.forName("UTF-16BE");
    boolean highOrderBit = false;
    boolean validU8Char = true;
int length = buffer.length;
    int i = 0;

while (i < length - 6)
    {
        byte b0 = buffer[i];
        byte b1 = buffer[i + 1];
        byte b2 = buffer[i + 2];
        byte b3 = buffer[i + 3];
        byte b4 = buffer[i + 4];
        byte b5 = buffer[i + 5];
        if (b0 < 0)

    {
        highOrderBit = true;
            // a two-bytes sequence was encoutered
            if (isTwoBytesSequence(b0))
            {
                if (!isContinuationChar(b1))
                validU8Char = false;
                else
                    i++;
            }
            // a three-bytes sequence was encoutered

            else if (isThreeBytesSequence(b0))

            {

                // there must be two continuation bytes of the form 10xxxxxx,

                // otherwise the following characteris is not a valid UTF-8 construct

                if (!(isContinuationChar(b1) && isContinuationChar(b2)))

                    validU8Char = false;

                else

                    i += 2;

            }

            // a four-bytes sequence was encoutered

            else if (isFourBytesSequence(b0))

            {

                // there must be three continuation bytes of the form 10xxxxxx,

                // otherwise the following characteris is not a valid UTF-8 construct

                if (!(isContinuationChar(b1) && isContinuationChar(b2) && isContinuationChar(b3)))

                    validU8Char = false;

                else

                    i += 3;

            }

            // a five-bytes sequence was encoutered

            else if (isFiveBytesSequence(b0))

            {

                // there must be four continuation bytes of the form 10xxxxxx,

                // otherwise the following characteris is not a valid UTF-8 construct

                if (!(isContinuationChar(b1) && isContinuationChar(b2) && isContinuationChar(b3) && isContinuationChar(b4)))

                    validU8Char = false;

                else

                    i += 4;

            }

            // a six-bytes sequence was encoutered

            else if (isSixBytesSequence(b0))

            {

                // there must be five continuation bytes of the form 10xxxxxx,

                // otherwise the following characteris is not a valid UTF-8 construct

                if (!(isContinuationChar(b1) && isContinuationChar(b2) && isContinuationChar(b3) && isContinuationChar(b4) && isContinuationChar(b5)))

                    validU8Char = false;

                else

                    i += 5;

            }

            else

                validU8Char = false;

        }

        if (!validU8Char) break;

        i++;

    }

    // if no byte with an high order bit set, the encoding is US-ASCII

    // (it might have been UTF-7, but this encoding is usually internally used only by mail systems)

    if (!highOrderBit)

    {

        // returns the default charset rather than US-ASCII if the enforce8Bit flag is set.

        if (this.enforce8Bit)

            return this.defaultCharset;

        else

            return Charset.forName("US-ASCII");

    }

    // if no invalid UTF-8 were encountered, we can assume the encoding is UTF-8,

    // otherwise the file would not be human readable

    if (validU8Char) return Charset.forName("UTF-8");

    // finally, if it's not UTF-8 nor US-ASCII, let's assume the encoding is the default encoding

    return this.defaultCharset;

}



public static Charset guessEncoding(File f, int bufferLength) throws FileNotFoundException, IOException

{

    FileInputStream fis = new FileInputStream(f);

    byte[] buffer = new byte[bufferLength];

    fis.read(buffer);

    fis.close();

    CharsetToolkit toolkit = new CharsetToolkit(buffer);

    toolkit.setDefaultCharset(getDefaultSystemCharset());

    return toolkit.guessEncoding();

}



public static Charset guessEncoding(File f, int bufferLength, Charset defaultCharset) throws FileNotFoundException, IOException

{

    FileInputStream fis = new FileInputStream(f);

    byte[] buffer = new byte[bufferLength];

    fis.read(buffer);

    fis.close();

    CharsetToolkit toolkit = new CharsetToolkit(buffer);

    toolkit.setDefaultCharset(defaultCharset);

    return toolkit.guessEncoding();

}



/**

 * If the byte has the form 10xxxxx, then it's a continuation byte of a multiple byte character;

 *

 * @param b a byte.

 * @return true if it's a continuation char.

 */

private static boolean isContinuationChar(byte b)

{

    return -128 <= b && b <= -65;

}



/**

 * If the byte has the form 110xxxx, then it's the first byte of a two-bytes sequence character.

 *

 * @param b a byte.

 * @return true if it's the first byte of a two-bytes sequence.

 */

private static boolean isTwoBytesSequence(byte b)

{

    return -64 <= b && b <= -33;

}



/**

 * If the byte has the form 1110xxx, then it's the first byte of a three-bytes sequence character.

 *

 * @param b a byte.

 * @return true if it's the first byte of a three-bytes sequence.

 */

private static boolean isThreeBytesSequence(byte b)

{

    return -32 <= b && b <= -17;

}



/**

 * If the byte has the form 11110xx, then it's the first byte of a four-bytes sequence character.

 *

 * @param b a byte.

 * @return true if it's the first byte of a four-bytes sequence.

 */

private static boolean isFourBytesSequence(byte b)

{

    return -16 <= b && b <= -9;

}