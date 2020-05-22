/**
 * Helper class that allows intercepting the XML to model mapping, to support backwards compatibility.
 * <p>
 * 2 methods must be overridden to handle compatibility mappings:
 * <dl>
 * <dt>{@link XMLHelperImpl#getFeature(EClass, String, String, boolean)}</dt>
 * <dd>Is called to map features of a certain EClass. These include attributes and child elements in the XML file.</dd>
 * <dt>{@link XMLHelperImpl#getType(EFactory, String)}</dt>
 * <dd>Is called to map types that are used in the model.</dd>
 * </dl>
 * <p>
 * Their difference becomes clear by looking at the model file. Sometimes both need to be handled. For example:
 * <ul>
 * <li>a {@link Person} has zero or more {@link Person#getPhoneNumber()} configurations ('feature')</li>
 * <li>these features are of type {@link PhoneNumber} or possibly a subclass! ('type')</li>
 * </ul>
 * <p>
 * See https://www.eclipse.org/forums/index.php/m/1449615/
 */
public class CustomXmlHelper extends XMLHelperImpl implements XMLHelper {

    public CustomXmlHelper() {
        super();
        deresolve = true;
    }

    public CustomXmlHelper(XMLResource resource) {
        super(resource);
        deresolve = true;
    }

    @Override
    public EStructuralFeature getFeature(EClass eClass, String namespaceURI, String name, boolean isElement) {
        String compatName = name;
        if (eClass == ProjectModelPackage.Literals.MyClass) {
            if (!isElement && "Name".equals(name)) {
                 // 1.x to 2.x compatibility (October 2014)
                 //   1.x = MyClass attribute 'Name'
                 //   2.x = MyBaseClass attribute 'name', shared by MyClass
                 compatName = ProjectModelPackage.Literals.EMY_BASE_CLASS__NAME.getName(); // 'n(!)ame'
            }
        }
        // future feature mappings handled here
        return super.getFeature(eClass, namespaceURI, compatName, isElement);
    }

    @Override
    public EClassifier getType(EFactory eFactory, String name) {
    String compatName = name;
        if (eFactory == ProjectModelPackage.eINSTANCE) {
            // placeholder for type compatibility
            //            if ("OldTypeName".equals(name)) {
            //                compatName = ProjectModelPackage.Literals.NEW_TYPE_NAME.getName();
            //            }
        }
        return super.getType(eFactory, compatName);
    }
}