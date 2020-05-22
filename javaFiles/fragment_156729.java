import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.Assert;

import java.io.File;

public class SampleConf {
    public final SampleConf.Address Address;
    public final SampleConf.Person Person;

    public static class Address {
        public final int Pin;

        public Address(final com.typesafe.config.Config c) {
            this.Pin = c.hasPathOrNull("Pin") ? c.getInt("Pin") : 500;
        }
    }

    public static class Person {
        public final java.lang.String Name;
        public final int PhoneNumber;

        public Person(final com.typesafe.config.Config c) {
            this.Name = c.hasPathOrNull("Name") ? c.getString("Name") : "ABC";
            this.PhoneNumber = c.hasPathOrNull("PhoneNumber") ? c.getInt("PhoneNumber") : 123;
        }
    }

    public SampleConf(final com.typesafe.config.Config c) {
        this.Address = new SampleConf.Address(c.getConfig("Address"));
        this.Person = new SampleConf.Person(c.getConfig("Person"));
    }

    public static void main(final String[] args) {

        final Config config = ConfigFactory.parseFile(
                new File(("problem.so.hocon.conf"))) // file path
                .resolve();
        final SampleConf conf = new SampleConf(config);
        // do everything  you like
        final SampleConf.Address address = conf.Address;
        final SampleConf.Person person = conf.Person;
        Assert.assertEquals(500, address.Pin);
    }

}