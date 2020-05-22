assertThat(quote.getModels(),
                            hasItem(Matchers.<PhoneModel> hasProperty("makeId",
                                            equalTo(LG_ID))));
            assertThat(quote.getModels(),
                            hasItem(Matchers.<PhoneModel> hasProperty("modelId",
                                            equalTo(NEXUS_4_ID))));
    }