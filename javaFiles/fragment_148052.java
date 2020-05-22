// read YAML file
Map<String, Object> user = objectMapper.readValue(new File("user.yaml"),
            new TypeReference<Map<String, Object>>() { });

// modify the address
Map<String, Object> address = (Map<String, Object>) user.get("address");
address.put("line1", "Your address line 1");
address.put("line2", "Your address line 2");
address.put("city", "Bangalore");
address.put("zip", 560010);

// write YAML file
objectMapper.writeValue(new File("user-modified.yaml"), user);