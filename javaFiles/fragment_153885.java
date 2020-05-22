GsonFireBuilder builder = new GsonFireBuilder()
        .registerTypeSelector(Base.class, new TypeSelector<Base>() {
            @Override
            public Class<? extends Base> getClassForElement(JsonElement readElement) {
                String typ = readElement.getAsJsonObject().get("typ").getAsString();
                if("a".equals(typ)){
                    return A.class;
                } else if("b".equals(typ)) {
                    return B.class;
                } else { //"base".equals(typ)
                    return Base.class;
                }
            }
        });

    Gson gson = builder.createGson();

    A a = new A();
    a.typ = "a";

    B b = new B();
    b.typ = "b";

    Base base = new Base();
    base.typ = "base";

    String jsona = gson.toJson(a);
    String jsonb = gson.toJson(b);
    String jsonbase = gson.toJson(base);

    Base ba = gson.fromJson(jsona, Base.class); // ^ returns A
    Base bb = gson.fromJson(jsonb, Base.class); // ^ returns B
    Base bbase = gson.fromJson(jsonbase, Base.class); // ^ returns Base