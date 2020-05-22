import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.ser.*;
import com.fasterxml.jackson.databind.util.NameTransformer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.*;

public class SO45698499 {


    public static void main(String [] args) throws Exception {
        ObjectWriter writer = createMapper().writerWithDefaultPrettyPrinter();
        String val = writer.writeValueAsString(new City("New York",
                Arrays.asList(new Person("Foo", 123), new Person("Baz", 22))));

        System.out.println(val);
    }


    /**
     * Constructs our mapper with the serializer modifier in mind
     * @return
     */
    public static ObjectMapper createMapper() {
        FlattenCollectionSerializerModifier modifier = new FlattenCollectionSerializerModifier();
        SerializerFactory sf = BeanSerializerFactory.instance.withSerializerModifier(modifier);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializerFactory(sf);

        return mapper;
    }

    @Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface FlattenCollection {
    }

    /**
     * Looks for the FlattenCollection annotation and modifies the bean writer
     */
    public static class FlattenCollectionSerializerModifier extends BeanSerializerModifier {

        @Override
        public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {
            for (int i = 0; i < beanProperties.size(); i++) {
                BeanPropertyWriter writer = beanProperties.get(i);
                FlattenCollection annotation = writer.getAnnotation(FlattenCollection.class);
                if (annotation != null) {
                    beanProperties.set(i, new FlattenCollectionPropertyWriter(writer));
                }
            }
            return beanProperties;
        }
    }

    /**
     * Instead of writing a collection as an array, flatten the objects down into values.
     */
    public static class FlattenCollectionPropertyWriter extends BeanPropertyWriter {
        private final BeanPropertyWriter writer;

        public FlattenCollectionPropertyWriter(BeanPropertyWriter writer) {
            super(writer);
            this.writer = writer;
        }

        @Override
        public void serializeAsField(Object bean,
                                     JsonGenerator gen,
                                     SerializerProvider prov) throws Exception {
            Object arrayValue = writer.get(bean);

            // lets try and look for array and collection values
            final Iterator iterator;
            if(arrayValue != null && arrayValue.getClass().isArray()) {
                // deal with array value
                iterator = Arrays.stream((Object[])arrayValue).iterator();
            } else if(arrayValue != null && Collection.class.isAssignableFrom(arrayValue.getClass())) {
                iterator = ((Collection)arrayValue).iterator();
            } else {
                iterator = null;
            }

            if(iterator == null) {
                // TODO: write null? skip? dunno, you gonna figure this one out
            } else {
                int index=0;
                while(iterator.hasNext()) {
                    index++;
                    Object value = iterator.next();
                    if(value == null) {
                        // TODO: skip null values and still increment or maybe dont increment? You decide
                    } else {
                        // TODO: OP - update your prefix/suffix here, its kinda weird way of making a prefix
                        final String prefix = value.getClass().getSimpleName().toLowerCase();
                        final String suffix = "_"+index;
                        prov.findValueSerializer(value.getClass())
                                .unwrappingSerializer(new FlattenNameTransformer(prefix, suffix))
                                .serialize(value, gen, prov);
                    }
                }
            }
        }
    }

    public static class FlattenNameTransformer extends NameTransformer {

        private final String prefix;
        private final String suffix;

        public FlattenNameTransformer(String prefix, String suffix) {
            this.prefix = prefix;
            this.suffix = suffix;
        }

        @Override
        public String transform(String name) {
            // captial case the first letter, to prepend the suffix
            String transformedName = Character.toUpperCase(name.charAt(0)) + name.substring(1);
            return prefix + transformedName + suffix;
        }
        @Override
        public String reverse(String transformed) {
            if (transformed.startsWith(prefix)) {
                String str = transformed.substring(prefix.length());
                if (str.endsWith(suffix)) {
                    return str.substring(0, str.length() - suffix.length());
                }
            }
            return null;
        }
        @Override
        public String toString() { return "[FlattenNameTransformer('"+prefix+"','"+suffix+"')]"; }
    }


    /*===============================
     * POJOS
     ===============================*/
    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public static class City {
        private String titleCity;
        private List<Person> people;

        public City(String title, List<Person> people) {
            this.titleCity = title;
            this.people = people;
        }

        public String getTitleCity() {
            return titleCity;
        }

        public void setTitleCity(String titleCity) {
            this.titleCity = titleCity;
        }

        @FlattenCollection
        public List<Person> getPeople() {
            return people;
        }

        public void setPeople(List<Person> people) {
            this.people = people;
        }
    }
}