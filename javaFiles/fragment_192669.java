import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.persister.collection.BasicCollectionPersister;
import org.hibernate.persister.collection.OneToManyPersister;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.type.ManyToOneType;
import org.hibernate.type.OneToOneType;
import org.hibernate.type.Type;

/**
 *
 * @author shruti
 */
public class RelationDemo {

    public static void main(String[] args) throws Exception {

        Configuration configuration = new Configuration().configure();
        ServiceRegistryBuilder builder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionfactory = configuration.buildSessionFactory(builder.buildServiceRegistry());

        //1. Read class names
        System.out.println("Enter first class names (make sure you enter fully qualified name): ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String class1 = bufferedReader.readLine();
        System.out.println("Enter second class names (make sure you enter fully qualified name): ");
        String class2 = bufferedReader.readLine();

        ClassMetadata classMetadata = null;

        //2. Create ClassMetaData for the first class name and check that both the classes exists.
        try {
            classMetadata = sessionfactory.getClassMetadata(Class.forName(class1));
            Class.forName(class2);
        } catch (ClassNotFoundException classNotFoundException) {
            System.err.println("Invalid class name.\nHint: Enter fully qualified class names for eg. packagename.Classname");
            classNotFoundException.printStackTrace(System.err);
            return;
        }

        //3. Retrieve all collection metada for collection type properties
        @SuppressWarnings("unchecked")
        Map<String, CollectionMetadata> allCollectionMetadata = sessionfactory.getAllCollectionMetadata();

        //Retrieve all properties of the first class
        String[] propertyNames = classMetadata.getPropertyNames();

        //Loop through the retrieved properties
        for (String name : propertyNames) {

            //Retrieve type of each property
            Type type = classMetadata.getPropertyType(name.trim());

            //Check if the type is association type
            if (type.isAssociationType()) {

                //Check if it is collection type.
                if (type.isCollectionType()) {

                    //From retrieved collection metadata (Strp 3) get value of the property we are refering to.
                    CollectionMetadata collectionMetadata = allCollectionMetadata.get(class1 + "." + name);

                    //Check if the elements of the collection are of desiered type
                    if (collectionMetadata.getElementType().getName().trim().equals(class2)) {
                        System.out.println("Property Name: " + name);
                        //Check if the value is of type OneToManyPersister
                        if (collectionMetadata instanceof OneToManyPersister) {
                            System.out.println("ONE TO MANY TYPE");
                            return;
                        } //Check if the value is of type BasicCollectionPersister. Note that for many to many relationship it would return an object of type BasicCollectionPersister.
                        else if (collectionMetadata instanceof BasicCollectionPersister) {
                            if (((BasicCollectionPersister) collectionMetadata).isManyToMany()) {
                                System.out.println("MANY TO MANY");
                            }
                        }
                    }
                } //If property is not a collection then retrieve the class of the type and check if it is the same as Second class.
                else if (type.getReturnedClass().getTypeName().equals(class2)) {
                    System.out.println("Property Name: " + name);
                    if (type instanceof ManyToOneType) {
                        System.out.println("MANY TO ONE TYPE");
                        return;
                    } else if (type instanceof OneToOneType) {
                        System.out.println("ONE TO ONE TYPE");
                        return;
                    }
                }
            }
        }
        System.out.println("NO RELATIONSHIP FOUND BETWEEN GIVEN CLASSES");
    }
}