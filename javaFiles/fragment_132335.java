GsonBuilder gsonBuilder = new GsonBuilder();
Gson gson = gsonBuilder.create();
Basliklar b = new Basliklar();
b.basliklar = new ArrayList<Baslik>();
Baslik b1 = new Baslik();
b1.setBaslikAdi("Deneme1");
b1.setBaslikAcan("funstein");
b1.setBaslikID(0);
b.basliklar.add(b1);
Baslik b2 = new Baslik();
b2.setBaslikAdi("Deneme2");
b2.setBaslikAcan("qeremqazan");
b2.setBaslikID(1);
b.basliklar.add(b2);

LoggerFactory.getLogger(TestHttpGet.class).debug(gson.toJson(b));