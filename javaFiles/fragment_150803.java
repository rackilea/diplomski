...
StringBuilder sb = new StringBuilder("");
sb.append("CREATE table Animal (\n");
    sb.append("ID INTEGER NOT NULL,\n");
    sb.append("AnimalName varchar(15),\n");
    sb.append("Char1 varchar(15),\n");
    sb.append("Char2 varchar(15),\n");
    sb.append("Char3 varchar(15),\n");
    sb.append("Char4 varchar(15)\n"); // <-- unnecessary comma

sb.append(")\n");
...