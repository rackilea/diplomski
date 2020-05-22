import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.batik.transcoder.Transcoder;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.fop.svg.PDFTranscoder;

public class Test {
    public static void main(String[] argv) throws TranscoderException, FileNotFoundException {
        Transcoder transcoder = new PDFTranscoder();
        TranscoderInput transcoderInput = new TranscoderInput(new FileInputStream(new File("/tmp/test.svg")));
        TranscoderOutput transcoderOutput = new TranscoderOutput(new FileOutputStream(new File("/tmp/test.pdf")));
        transcoder.transcode(transcoderInput, transcoderOutput);
    }
}