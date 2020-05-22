if (dups.size() > 0) {
        StringBuilder sb = new StringBuilder("There are duplicates: ");
        for (String studentname : dups) {
            sb.append(studentname).append(", ");
        }
        String msg = sb.toString();
        msg = msg.substring(0, msg.length() - 2);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }