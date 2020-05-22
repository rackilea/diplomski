String val = "Gambia";
String field = "";

for (Code c : Code.values())
    if (c.getStringValue().equals(val)) {
        field = c.name();
        break;
    }

System.out.println(field);