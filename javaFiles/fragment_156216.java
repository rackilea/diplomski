InputStreamResource resource = new InputStreamResource(s3Object.getObjectContent());

    System.out.println("postal codes:");
    try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }