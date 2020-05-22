public class Message {

    private List<? extends Result> body;
    private Header header;

    public Message(List<? extends Result> body, Header header) {
        this.body = body;
        this.header = header;
    }


    public List<? extends Result> getBody() {
        return body;
    }

    public Header getHeader() {
        return header;
    }

}

public class Header {
    private String contentver;

    public Header(String contentVer) {
        this.contentver = contentVer;
    }

    public String getContentVer() {
        return contentver;
    }
}

public interface Result {    
    public Rule getRule();    
}

public final class Rule {
    private String ruleid;

    public String getRuleid() {
        return ruleid;
    }
}

public class DurationResults implements Result {
    private Duration[] result;
    private Rule rule;

    public Duration[] getResult() {
        return result;
    }

    @Override
    public Rule getRule() {
        return rule;
    }

    public static final class Duration {
        private long EndTime;
        private long StartTime;

        public long getStartTime() {
            return StartTime;
        }

        public long getEndTime() {
            return EndTime;
        }
    }
}

public class ErrorResults implements Result {    
    private Error[] result;
    private Rule rule;

    public Error[] getResult() {
        return result;
    }

    @Override
    public Rule getRule() {
        return rule;
    }

    public static final class Error {
        private int noOfErrors;
        private String severity;

        public int getNoOfErrors() {
            return noOfErrors;
        }

        public String getSeverity() {
            return severity;
        }
    }
}