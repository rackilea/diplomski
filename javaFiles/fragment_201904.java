import org.dozer.DozerBeanMapper;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TestFemaleToMaleConversion {

    private static Female femaleObj;

    @BeforeAll
    private static void initData() {
        Map<String, List<Contact>> contact = new LinkedHashMap<>();
        List<Contact> listOfContacts = new ArrayList<>();
        Contact contactObj = new Contact();
        contactObj.setEmail("lala@gmail.com");
        contactObj.setPostcode("1233355");
        contactObj.setStreet("street");

        listOfContacts.add(contactObj);

        contact.put("2131323213", listOfContacts);
        femaleObj = new Female();
        femaleObj.setName("Elisabeth");
        femaleObj.setSurname("Chesny");
        femaleObj.setContacts(contact);
    }

    @Test
    void testWithXmlMapping() {
        DozerBeanMapper objectMapper = new DozerBeanMapper();
        objectMapper.setMappingFiles(Arrays.asList("dozer-mapping.xml"));
        Male maleObj = objectMapper.map(femaleObj, Male.class);

        Assert.assertEquals("lala@gmail.com", maleObj.getContacts().get("2131323213").get(0).getEmail());
    }

    @Test
    void testWithJavaMapping() {
        DozerBeanMapper objectMapper = new DozerBeanMapper();
        objectMapper.addMapping(new CustomMapper());
        Male maleObj = objectMapper.map(femaleObj, Male.class);

        Assert.assertEquals("street", maleObj.getContacts().get("2131323213").get(0).getStreet());
    }
}