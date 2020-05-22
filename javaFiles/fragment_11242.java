package forum11319741;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Response {

        public static final String ERROR_FIELD_NAME = "error";
        public static final String ERROR_CODE_FIELD_NAME = "error_code";

        @XmlElement(name = Response.ERROR_CODE_FIELD_NAME, nillable = true)
        private String errorCode;

        @XmlElement(name = Response.ERROR_FIELD_NAME, nillable = true)
        private String errorMessage;

}