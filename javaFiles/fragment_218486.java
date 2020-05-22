for (List<String> line : result) {
        for (String element : line) {
            sb.append(element);
            sb.append(",");
        }
        sb.setCharAt(sb.length() - 1, '\n');
    }