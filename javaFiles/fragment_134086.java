public class ReportConverter implements Converter { 

    @Override 
    public boolean canConvert(Class classs) { 
        System.out.println("canConvert: " + classs.getName());
        return classs.equals(Report.class); 
    } 

    @Override 
    public void marshal(Object value, HierarchicalStreamWriter writer, 
            MarshallingContext context) {
        // not used in this example
    } 

    // goes recursive through all the nodes in <report>
    String getNodeAsText(HierarchicalStreamReader reader) {
        String result;
        result = "<" + reader.getNodeName() + ">" + reader.getValue();
        while (reader.hasMoreChildren() ) {
            reader.moveDown();
            result += getNodeAsText(reader);
            reader.moveUp();
            result += reader.getValue();
        }
        result += "</" + reader.getNodeName() + ">";
        return result;
    }

    @Override 
    public Object unmarshal(HierarchicalStreamReader reader, 
            UnmarshallingContext context) {
        Report xReport = new Report();
        xReport.report = reader.getValue();
        while (reader.hasMoreChildren() ) {
            reader.moveDown();
            xReport.report += getNodeAsText(reader);
            reader.moveUp();
            xReport.report += reader.getValue();
        }
        return xReport; 
    } 
}