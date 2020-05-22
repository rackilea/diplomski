ObjectMapper objMap = new ObjectMapper();

Libell libell = objMap.convertValue(objectNode.get("libellePrerequis"), Libell.class);

System.out.println(libell.getId());
System.out.println(libell.getProduit().getId());
System.out.println(libell.getTypologie().getId());