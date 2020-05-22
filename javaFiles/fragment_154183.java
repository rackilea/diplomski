public class DbSubProcessResolver implements SubProcessResolver {
    private static final long serialVersionUID = 1L;

        public ProcessDefinition findSubProcess(Element subProcessElement) {

            String name = subProcessElement.attributeValue("name").replaceAll(
                "\\.", "");
            ProcessDefinition subProcessDefinition = ProcessDefinition
                .parseXmlResource(name + "/processdefinition.xml");

            return subProcessDefinition;
        }
}