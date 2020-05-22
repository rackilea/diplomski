List<MeModel> meModels = new ArrayList<>();

meModels.clear();
meModels.add(new MeModel(...));
// ^^^^^ add item
meModels.get(0).setFirstname("Hello"); // get item
meModels.get(0).setLastname("World");