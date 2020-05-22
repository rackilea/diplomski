Map<String, Map<String, String>> metrics = new HashMap<>();
metrics.put("test", new HashMap<>());

ByteArrayOutputStream bo = new ByteArrayOutputStream();

ObjectOutputStream so = new ObjectOutputStream(bo);
so.writeObject(metrics);
so.close();

ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
ObjectInputStream si = new ObjectInputStream(bi);
Map<String, Map<String, String>> result = (Map<String, Map<String, String>>) si.readObject();
si.close();

System.out.println(result.equals(metrics)); // true