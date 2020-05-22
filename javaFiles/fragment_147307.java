bindMultibinder(ImmutableList.of(
                    new Key<CruiseControlSubOptOne>() {},
                    new Key<CruiseControlSubOptTwo>() {},
                    Key.get(CruiseControl.class, Names.named("ThirdOpt")),
                    Key.get(CruiseControl.class, Names.named("FourthOpt"))),
                new Key<Option>() {});