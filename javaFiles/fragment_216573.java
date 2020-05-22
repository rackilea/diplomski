String name = "David Lee:Cephaloscyllium ventriosum";
        Set<String> set = new HashSet<>();

            String[] sharks = name.split("[^a-zA-Z]+");
            for(String token: sharks) {
                if(token.length()%2==0)
                    set.add(token);
            }
        return set.size();