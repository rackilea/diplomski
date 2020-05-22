import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.expiry.Expirations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CacheHelper {


    private CacheManager cacheManager;

    private Cache<String, PersonList> cacheDataList;

    private static final String CACHE_PERSON = "cache_key_person";

    private static class Person {
        final String name;

        public Person(final String name) {
            this.name = name;
        }
    }

    private class PersonList extends ArrayList<Person> {
        public PersonList(final Collection<? extends Person> c) {
            super(c);
        }
    }

    public static void main(String[] args) {


        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Bob"));
        persons.add(new Person("Sally"));

        CacheHelper helper = new CacheHelper();
        helper.putInList(persons);
        PersonList personList = helper.cacheDataList.get(CACHE_PERSON);
        for (Person p : personList) {
            System.out.println("Found " + p.name);
        }

    }

    public CacheHelper() {
        System.getProperties().setProperty("java -Dnet.sf.ehcache.use.classic.lru", "true");
        cacheManager = CacheManagerBuilder
                .newCacheManagerBuilder().build();
        cacheManager.init();
        cacheDataList = cacheManager
                .createCache("cacheOfPersonList", CacheConfigurationBuilder
                        .newCacheConfigurationBuilder(String.class, PersonList.class, ResourcePoolsBuilder.heap(10))
                        .withExpiry(Expirations.timeToLiveExpiration(org.ehcache.expiry.Duration.of(20, TimeUnit.SECONDS))));
    }


    public void putInList(List<Person> personList) {
        System.out.println("putting list in cache");
        cacheDataList.put(CACHE_PERSON, new PersonList(personList));
    }


}