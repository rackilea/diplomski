import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.integration.transformer.MessageTransformationException;
import org.springframework.messaging.Message;
import org.springframework.util.Assert;

public class FileSplitter extends AbstractMessageSplitter {
    private static final Logger log = LoggerFactory.getLogger(FileSplitter.class);

    private String commentPrefix = "#";

    public Object splitMessage(Message<?> message) {
        if(log.isDebugEnabled()) {
            log.debug(message.toString());
        }
        try {

            Object payload = message.getPayload();
            Assert.isInstanceOf(File.class, payload, "Expected java.io.File in the message payload"); 

            return new BufferedReaderFileIterator((File) payload);
        } 
        catch (IOException e) {
            String msg = "Unable to transform file: " + e.getMessage();
            log.error(msg);
            throw new MessageTransformationException(msg, e);
        }
    }

    public void setCommentPrefix(String commentPrefix) {
        this.commentPrefix = commentPrefix;
    }

    public class BufferedReaderFileIterator implements Iterator<String> {

        private File file;
        private BufferedReader bufferedReader;
        private String line;

        public BufferedReaderFileIterator(File file) throws IOException {
            this.file = file;
            this.bufferedReader = new BufferedReader(new FileReader(file));
            readNextLine();
        }

        @Override
        public boolean hasNext() {
            return line != null;
        }

        @Override
        public String next() {
            try {
                String res = this.line;
                readNextLine();
                return res;
            } 
            catch (IOException e) {
                log.error("Error reading file", e);
                throw new RuntimeException(e);
            }   
        }

        void readNextLine() throws IOException {
            do {
                line = bufferedReader.readLine();
            }
            while(line != null && line.trim().startsWith(commentPrefix));

            if(log.isTraceEnabled()) {
                log.trace("Read next line: {}", line);
            }

            if(line == null) {
                close();
            }
        }

        void close() throws IOException {
            bufferedReader.close();
            file.delete();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

}