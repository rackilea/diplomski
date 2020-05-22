List<String> targetKeys = target.stream().filter(
           s->s.length()>4
     ).map(
           s->s.substring(1,5)
     ).collect(Collectors.toList());

List<String> sourceKeys = source.stream().filter(
           s->s.length()>4
     ).map(
           s->s.substring(1,5)
     ).collect(Collectors.toList());