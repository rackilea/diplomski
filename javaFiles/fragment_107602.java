import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "header",
        "data"
})
@XmlRootElement(name = "ACKMessageVo")
public class ACKMessageVo {

    @XmlElement(required = true)
    private String header;
    @XmlElement(required = true)
    private ACKMessageVo.Data data;

    public String getHeader() {
        return header;
    }

    public void setHeader(String value) {
        this.header = value;
    }

    public ACKMessageVo.Data getData() {
        return data;
    }

    public void setData(ACKMessageVo.Data value) {
        this.data = value;
    }


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "combinationFilename",
            "checksumFilename",
            "sscXmlFilename",
            "acknowledgement"
    })
    public static class Data {

        @XmlElement(name = "combination_filename", required = true)
        private String combinationFilename;
        @XmlElement(name = "checksum_filename", required = true)
        private String checksumFilename;
        @XmlElement(name = "ssc_xml_filename", required = true)
        private String sscXmlFilename;
        @XmlElement(required = true)
        private String acknowledgement;

        public String getCombinationFilename() {
            return combinationFilename;
        }

        public void setCombinationFilename(String value) {
            this.combinationFilename = value;
        }

        public String getChecksumFilename() {
            return checksumFilename;
        }

        public void setChecksumFilename(String value) {
            this.checksumFilename = value;
        }

        public String getSscXmlFilename() {
            return sscXmlFilename;
        }

        public void setSscXmlFilename(String value) {
            this.sscXmlFilename = value;
        }

        public String getAcknowledgement() {
            return acknowledgement;
        }

        public void setAcknowledgement(String value) {
            this.acknowledgement = value;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "combinationFilename='" + combinationFilename + '\'' +
                    ", checksumFilename='" + checksumFilename + '\'' +
                    ", sscXmlFilename='" + sscXmlFilename + '\'' +
                    ", acknowledgement='" + acknowledgement + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ACKMessageVo{" +
                "header='" + header + '\'' +
                ", data=" + data +
                '}';
    }
}