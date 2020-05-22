Dog dog = new Dog("val1", "val2", "val3");
            List<String> list = new ArrayList<>();
            for(Field field: Dog.class.getDeclaredFields()) {
                // since fields are private we need to first mark it accesible
                field.setAccessible(true);
                if( field.getType().equals(String.class)) {
                        list.add((String) field.get(dog));
                }
            }