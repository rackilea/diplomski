public class ScanningPropertyPlaceholderConfigurer extends org.springframework.beans.factory.config.PropertyPlaceholderConfigurer {
    @Override
       public void setLocation(Resource location) {
       File file = findFile(fileName);  // implement file finder
       super.setLocation(new FileSystemResource(file));
    }
}