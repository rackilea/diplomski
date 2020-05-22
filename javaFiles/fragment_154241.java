import java.io.IOException;
    import java.util.Collection;
    import java.util.Iterator;

    import com.icafe4j.image.meta.Metadata;
    import com.icafe4j.image.meta.MetadataEntry;
    import com.icafe4j.image.meta.MetadataType;
    import com.icafe4j.image.meta.icc.ICCProfile;

    public class ExtractICCProfile {

        public static void main(String[] args) throws IOException {
            Map<MetadataType, Metadata> metadataMap = Metadata.readMetadata(args[0]);
            ICCProfile icc_profile = (ICCProfile)metadataMap.get(MetadataType.ICC_PROFILE);

            if(icc_profile != null) {
                Iterator<MetadataEntry> iterator = icc_profile.iterator();

                while(iterator.hasNext()) {
                    MetadataEntry item = iterator.next();
                    printMetadata(item, "", "     ");
                }
            }   
        }
        private void printMetadata(MetadataEntry entry, String indent, String increment) {
            logger.info(indent + entry.getKey() (StringUtils.isNullOrEmpty(entry.getValue())? "" : ": " + entry.getValue()));
            if(entry.isMetadataEntryGroup()) {
                 indent += increment;
                 Collection<MetadataEntry> entries = entry.getMetadataEntries();
                 for(MetadataEntry e : entries) {
                    printMetadata(e, indent, increment);
                 }          
            }
        }   
    }