while (line != null) {
            String[] split = line.split(",");
            Item item = new Item(new Integer(split[0]),split[1]);
            root.getitem().add(item);
            line = br.readLine();
        }

        createBeanFile(root);