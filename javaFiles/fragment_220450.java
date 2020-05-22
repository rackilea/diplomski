List<Hills> hillist = Hills.readHills();
    Map<String, Set<Hills>> hillsByCounty = Hills.hillsByCounty(hillist);

    Set<Map.Entry<String, Set<Hills>>> entrySet = hashMap.entrySet();
    Iterator<Map.Entry<String, Set<Hills>>> entryIterator = entry1.iterator();
    for(int i = 0; i < 3; i++){
            Map.Entry<String, Set<Hills>> mapEntry = entryIterator.next();
            System.out.println("### County: " + mapEntry.getKey());
            Set<Hills> hills = mapEntry.getValue();
            for (int j = 0; j < 3; j++) {     
                    Hill hill = iterator.next();
                    System.out.println(hill.hillName + " " + hill.height);
                }
            }
        }
    }