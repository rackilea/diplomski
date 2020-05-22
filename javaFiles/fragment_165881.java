Map map = new HashMap();
        map.put("1",new Integer(1));
        map.put("2",new Integer(2));
        map.put("3",new Integer(3));
        FileOutputStream fos = new FileOutputStream("map.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(map);
        oos.close();

        FileInputStream fis = new FileInputStream("map.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Map anotherMap = (Map) ois.readObject();
        ois.close();

        System.out.println(anotherMap);