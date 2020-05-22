import org.apache.avalon.framework.configuration.Configuration;
import org.apache.avalon.framework.configuration.DefaultConfigurationBuilder;
import org.apache.fop.apps.FopFactoryBuilder;

...
DefaultConfigurationBuilder cfgBuilder = new DefaultConfigurationBuilder();
Configuration cfg = cfgBuilder.buildFromFile(new File("/Users/lfurini/fop.xconf"));
FopFactoryBuilder fopFactoryBuilder = new FopFactoryBuilder(new File(".").toURI()).setConfiguration(cfg);
FopFactory fopFactory = fopFactoryBuilder.build();

FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
// configure foUserAgent as desired
foUserAgent.setAccessibility(true);
foUserAgent.getRendererOptions().put("pdf-a-mode", "PDF/A-1b");
...