factory.classMap(ClazzA.class, ClazzB.class)
                .field("name", "sname")
                .byDefault()
                .customize(new CustomMapper<ClazzA, ClazzB>() {
                    @Override
                    public void mapBtoA(ClazzB clazzB, ClazzA clazzA, MappingContext context) {
                        if ("stk".equals(clazzB.getType())) {
                            clazzA.setName(clazzB.getSName());
                        }
                    }                   
                }
                .register();