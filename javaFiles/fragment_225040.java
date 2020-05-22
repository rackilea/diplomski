@RunWith(JUnit4.class)
public class TempTest {

    @Test
    public void TestThis(){

        final ModelMapper mapper = new ModelMapper();
        mapper.addMappings(new PropertyMap<SrcClass, DestClass>() {
            @Override
            protected void configure() {
                this.map().setId(this.source.getId());
                this.map().setName(this.source.getName());
                mapper.createTypeMap(TypeEnum.class, TypeClass.class).setConverter(
                        new Converter<TypeEnum, TypeClass>() {
                            @Override
                            public TypeClass convert(MappingContext<TypeEnum, TypeClass> mappingContext) {
                                if (mappingContext.getSource() == null) {
                                    return null;
                                }
                                TypeEnum typeEnum = mappingContext.getSource();

                                TypeClass typeClass = new TypeClass();
                                typeClass.setId(typeEnum.getId());
                                typeClass.setName(typeEnum.getName());
                                return typeClass;
                            }
                        });

            }
        });

        SrcClass srcObj = new SrcClass();
        srcObj.setId(1);
        srcObj.setName("name");
        srcObj.setTypes(new HashSet<>(Arrays.asList(TypeEnum.TYPE1, TypeEnum.TYPE2)));

        DestClass dstObj = mapper.map(srcObj, DestClass.class);

        Assert.assertEquals(srcObj.getId(), dstObj.getId());
        Assert.assertEquals(srcObj.getName(), dstObj.getName());
        Assert.assertEquals(srcObj.getTypes().size(), dstObj.getTypes().size());

        for(TypeClass c : dstObj.getTypes()) {
            TypeEnum e = TypeEnum.getById(c.getId());
            Assert.assertNotNull(e);
            Assert.assertTrue(srcObj.getTypes().contains(e));
        }
    }

    public static <Source, Result> Set<Result> convertAll(Set<Source> source, Function<Source, Result> projection)
    {
        Set<Result> results = new HashSet<>();

        if(source == null) return results;

        for (Source element : source)
        {
            results.add(projection.apply(element));
        }

        return results;
    }

    public static class SrcClass{
        private Integer id;
        private String name;

        private Set<TypeEnum> types;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<TypeEnum> getTypes() {
            return types;
        }

        public void setTypes(Set<TypeEnum> types) {
            this.types = types;
        }
    }

    public static class DestClass{
        private Integer id;
        private String name;

        private Set<TypeClass> types;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<TypeClass> getTypes() {
            return types;
        }

        public void setTypes(Set<TypeClass> types) {
            this.types = types;
        }
    }

    public static enum TypeEnum{

        TYPE1(1, "Type 1")
        , TYPE2(2, "Type 2")
        , TYPE3(3, "Type 3")
        , TYPE4(4, "Type 4");

        private Integer id;
        private String name;

        TypeEnum(Integer id, String name) {
            this.id = id;
            this.name = name;
        }


        private static final Map<Integer, TypeEnum> byId = new HashMap<>();
        private static final Map<String, TypeEnum> byName = new HashMap<>();

        static {
            for (TypeEnum e : TypeEnum.values()) {
                if (byId.put(e.getId(), e) != null) {
                    throw new IllegalArgumentException("duplicate id: " + e.getId());
                }

                if (byName.put(e.getName(), e) != null) {
                    throw new IllegalArgumentException("duplicate name: " + e.getName());
                }
            }
        }

        public Integer getId() {
            return this.id;
        }

        public String getName() { return this.name; }

        public static TypeEnum getById(Integer id) {
            return byId.get(id);
        }

        public static TypeEnum getByName(String name) {
            return byName.get(name);
        }
    }

    public static class TypeClass{
        private Integer id;
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}