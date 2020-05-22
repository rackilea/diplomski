for (Person object : map.values()) {

                if (map.get(object) != null
                        && map.get(object).getNumber().equals(newNumber)) {

                    return false;
                }
            }