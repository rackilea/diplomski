List<String> allowedtags = new ArrayList();
List<String> unwantedtags = new ArrayList();
pattern.stream()
       .forEach(name -> {
                if (name.startsWith("-")) unwantedtags.add(name.substring(1));
                else allowedtags.add(name);
            }
        );