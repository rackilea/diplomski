getObject1s.stream()
        .filter(ob1s -> ob1s.hasChild != null)
        .forEach(ob1s ->{
            map1.get(ob1holder).add(ob1s);
            if(Boolean.TRUE.equal(ob1.getHolder)){  //null safe
                map1.get(ob11holder).add(ob1s.getID);
            }
            if (ob1s.getObject2 != null){
              ob1s.getObject2.getObjects.stream()
                     .forEach(ob2 -> map.get(ob2holder).add(ob2));
            }
    })