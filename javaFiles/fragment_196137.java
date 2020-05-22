while ((line = sc.readLine()) != null) {
        if (!line.trim().equals("")) {
            System.out.println(line);
            if (line.toLowerCase().contains("name")) {
                name.add(line.split("=")[1].trim());
            }
            if (line.toLowerCase().contains("id")) {
                id.add(line.split("=")[1].trim());
            }
            if (line.toLowerCase().contains("place")) {
                // change done here to add space if no value
                place.add(line.split("=").length > 1 ? line.split("=")[1]
                        .trim() : " ");
            }
            if (line.toLowerCase().contains("details")) {
                details.add(line.split("=")[1].trim());
            }
        }
    }