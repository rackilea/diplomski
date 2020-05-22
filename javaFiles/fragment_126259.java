values.forEach(val -> {
     EnumType type = EnumType.get(val);
     if(type != null){
          String key = type.name();
          if (key.equals("camp2"))
               key = "camp1";
          mapN.computeIfAbsent(key, x -> new ArrayList<>()).add(val);
     }
});