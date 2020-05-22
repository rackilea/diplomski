while (o != times) {
                int j = client.reciveCommando();
                System.out.println("j"+ j);
                    String name = client.reciveString();
                    System.out.println("Name " +name);
                    createUser(j, name);    
                o++;
            }