Map<Integer, String> result = stringStream
    .collect(HashMap::new, 
             (m, e) -> {
                 Integer key = this.getKey(e);
                 if(key != 0) {
                     m.merge(key, e, String::concat);
                 }
              }, 
              Map::putAll);