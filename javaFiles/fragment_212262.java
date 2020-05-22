ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
        Serializable payload = new Serializable() {
            @Override
            public String toString() {
                return "hello from the anonymous class";
            }
        };
        oos.writeObject(payload);
        oos.writeObject(payload.getClass());
    }

    try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
        System.out.println(in.readObject());
        System.out.println(in.readObject());
    }