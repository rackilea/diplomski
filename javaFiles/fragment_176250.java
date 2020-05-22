String result = Arrays.stream(string.split("\\n"))
                          .map(s -> {
                              String[] tokens = s.split(",");
                              Arrays.sort(tokens);
                              return String.join(",", tokens);
                          })
                          .collect(Collectors.joining("\\n"));

System.out.println(result); // aaa,bbb,ccc\n111,222,333\nxxx,yyy,zzz