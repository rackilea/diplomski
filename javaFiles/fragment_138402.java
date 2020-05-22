Collection<String> objects = result.getResult(String.class);


        Kryo kryo = new Kryo();
        kryo.register(Person.class);
        ObjectBuffer buffer = new ObjectBuffer(kryo);

        for (String s : objects)
        {
            Person p3 = buffer.readObject(s.getBytes(), Person.class);
            System.out.println(p3.getName() + " " + p3.getPhone());
        }

        client.shutdown();     
    }
}