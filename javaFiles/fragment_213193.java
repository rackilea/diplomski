import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@XmlRootElement(name = "ICExt")
@XmlAccessorType(XmlAccessType.FIELD)
@EqualsAndHashCode
@Setter
@Getter
@ToString
public class ICExt {
    @XmlElement(name = "AA")
    private AA aa;

    @Setter
    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    @EqualsAndHashCode
    public static class AA {
        @XmlElement(name = "PA1")
        private String pa1;
        @XmlElement(name = "PA2")
        private PA2 pa2;
    }

    @Setter
    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    @EqualsAndHashCode
    public static class PA2 {
        @XmlElement(name = "FFGAG")
        private FFGAG ffgag;
    }

    @Setter
    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    @EqualsAndHashCode
    public static class FFGAG {
        @XmlElement(name = "KICUC")
        private KICUC kicuc;
    }

    @Setter
    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    @EqualsAndHashCode
    public static class KICUC {
        @XmlElement(name = "R_CAT_NAME")
        private String rCatName;

        @XmlElement(name = "Employees")
        private List<Employee> employees = new LinkedList<>();

        @XmlElement(name = "params")
        private Params params;
    }

    @Setter
    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    @EqualsAndHashCode
    public static class Params {
        @XmlElement(name = "req_id")
        private String reqId;

        @XmlElement(name = "sdate")
        private Date startDate;

        @XmlElement(name = "rep_cat_id")
        private String repCatId;

        @XmlElement(name = "ldata_group_id")
        private String lDataGroupId;

        @XmlElement(name = "ac_param_group_id")
        private String acParamGroupId;

        @XmlElement(name = "edate")
        private Date endDate;

        @XmlElement(name = "FNAME")
        private String fName;
    }

    @Setter
    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    @EqualsAndHashCode
    public static class Employee {
        @XmlElement(name = "empl_rec")
        private EmplRec emplRec;
    }

    @Setter
    @Getter
    @XmlAccessorType(XmlAccessType.FIELD)
    @EqualsAndHashCode
    public static class EmplRec {
        @XmlElement(name = "Salary")
        private String salary;

        @XmlElement(name = "emp_id")
        private String empId;
    }
}


import javax.xml.bind.JAXBContext;
import java.io.StringReader;

public class ICExtUnmarshaler {

    public ICExt unmarshal(String xmlContent) throws Exception {
        JAXBContext context = JAXBContext.newInstance(ICExt.class);
        return (ICExt) context.createUnmarshaller().unmarshal((new StringReader(xmlContent)));
    }
}