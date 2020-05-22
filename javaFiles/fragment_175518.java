import de.hybris.platform.core.Registry;
import de.hybris.platform.core.PK.PKCounterGenerator;
import de.hybris.platform.persistence.numberseries.SerialNumberGenerator;

int key = 45;
int current = new de.hybris.platform.core.DefaultPKCounterGenerator().fetchNextCounter(key);
SerialNumberGenerator generator = Registry.getCurrentTenant().getSerialNumberGenerator();
generator.removeSeries("pk_"+key);
generator.createSeries("pk_"+key,1,current*10)