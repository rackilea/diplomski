List<ClassA> list1 = Collections.emptyList();
List<ClassB> list2 = list1.stream()
                          .map(a -> {
                              ClassB b = new ClassB();
                              b.setStudentId(a.getId());
                              b.setStudentName(a.getName());
                              b.setStudentPhone(a.getPhone());
                              return b;
                          })
                          .collect(Collectors.toList());