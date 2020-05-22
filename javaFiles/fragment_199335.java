import javax.xml.bind.JAXBElement
import org.apache.poi.openxml4j.exceptions.InvalidFormatException
import org.docx4j.openpackaging.packages.WordprocessingMLPackage
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart
import org.docx4j.wml.CTBookmark
import org.docx4j.wml.P
import org.docx4j.wml.R
import org.docx4j.wml.SdtBlock
import org.docx4j.wml.SdtContent
import org.docx4j.wml.SdtRun
import org.docx4j.wml.Text

class WordReport {
    private WordprocessingMLPackage document
    private Map<String, String> contentControlMapping
    private Map<String, Object> reportArgs

    public WordReport(Map<String, Object> reportArgs) {
        document = WordprocessingMLPackage.createPackage()
        this.reportArgs = reportArgs
    }

    public WordprocessingMLPackage exportReport() {
        return document
    }

    private String getNewMapping(String contentControlText)  {
        return contentControlMapping.get(contentControlText)
    }

    private boolean isMapped(String contentControlText) {
        return contentControlMapping.containsKey(contentControlText)
    }

    protected void mapNewMapping() {
        MainDocumentPart mainDocument = document.getMainDocumentPart()
        List<Object> nodes = mainDocument.getJAXBNodesViaXPath("//w:sdt", false)

        String key
        SdtContent content
        nodes.each { n ->
            if(n instanceof SdtBlock) {
                content = n.getSdtContent()
            }
            else if(n instanceof JAXBElement) {
                if(n.getValue() instanceof SdtRun) {
                    content = n.getValue().getSdtContent()
                }
            }

            content.getContent().each { sdtcc ->
                if(sdtcc instanceof P) {
                    sdtcc.getContent().each { pc ->
                        pc.getContent().each { rc ->
                            println "rc.getValue().getClass(): " + rc.getValue().getClass()
                            if(rc.getValue() instanceof Text) {
                                key = rc.getValue().getValue()
                                isMapped(key) ? rc.getValue().setValue(getNewMapping(key)) : null
                            }
                            else if(rc.getValue() instanceof R) {
                                rc.getValue().getContent().each { rrc ->
                                    if(rrc instanceof JAXBElement) {
                                        key = rrc.getValue().getValue()
                                        isMapped(key) ? rrc.getValue().setValue(getNewMapping(key)) : null
                                    }
                                }
                            }
                        }
                    }
                }
                else if(sdtcc instanceof R) {
                    sdtcc.getContent().each { rc ->
                        if(rc instanceof JAXBElement) {
                            key = rc.getValue().getValue()
                            isMapped(key) ? rc.getValue().setValue(getNewMapping(key)) : null
                        }
                    }
                }
                else if(sdtcc instanceof JAXBElement) {
                    if(sdtcc.getValue() instanceof CTBookmark) {

                    }
                    else if(sdtcc.getValue() instanceof JAXBElement) {
                        key = sdtcc.getValue().getValue()
                        isMapped(key) ? sdtcc.getValue().setValue(getNewMapping(key)) : null
                    }
                }
            }
        }
    }

    public void setMapping(Map contentControlMapping) {
        this.contentControlMapping = contentControlMapping
    }
}