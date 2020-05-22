List<K2Agents> result = iterable.getContent()
                                   .stream()
                                   .filter(i->i.getLastName().equals(searchName))
                                   .collect(Collectors.toList());

Page<K2Agent> r = new PageImpl<K2Agent>(result);