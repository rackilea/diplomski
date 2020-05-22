public class TabDescriptorProvider implements ITabDescriptorProvider {

    @Override
    public ITabDescriptor[] getTabDescriptors( IWorkbenchPart part, ISelection selection ) {
        AbstractTabDescriptor[] tabs = new AbstractTabDescriptor[1];
        tabs[0] = new TabDescriptor("Aww shucks, TabDescriptorTitle");

        return tabs;
    }

    class TabDescriptor extends AbstractTabDescriptor {
        String label;

        /**
         * Constructor
         * 
         * @param label sets the label text of the tab
         */
        TabDescriptor( String label ) {
            this.label = label;
        }

        @SuppressWarnings("rawtypes")
        @Override
        public List getSectionDescriptors() {
            List<SectionDescriptor> sList = new ArrayList<SectionDescriptor>();
            sList.add( new SectionDescriptor( label ) );

            return sList;
        }

        @Override
        public String getCategory() {
            //Stub
            return "";
        }

        @Override
        public String getId() {
            //stub
            return "";
        }

        @Override
        public String getLabel() {
            return "Resource";
        }
    }

    class SectionDescriptor extends AbstractSectionDescriptor {

        String section;
        List<AbstractPropertySection> sectionTabs = new ArrayList<AbstractPropertySection>();

        public SectionDescriptor( String section ) {
            this.section = section;

        }

        /**
         * SectionId
         */
        @Override
        public String getId() {
            //stub
            return "";
        }

        /**
         * SectionClass
         */
        @Override
        public ISection getSectionClass() {
            return new AuxiliaryProjectSection();
        }

        /**
         * SectionTab
         */
        @Override
        public String getTargetTab() {
            //stub
            return "";
        }

    }

}