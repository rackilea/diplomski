System.out.println(
    Arrays.stream(docIDs.split(","))
    .parallel() // included because OP included it
    .map(i -> {
        // this is how you should use Files.lines anyway
        try (Stream<String> lines = Files.lines(Paths.get(spamDir +"\\cw12-" + i.substring(10,16) + ".txt"))) {
           return lines
                       .filter(j -> j.matches("^(\\d\\d)\\s" + i)) 
                                    .map(line -> line.substring(0, line.indexOf(" "))) 
                       .findFirst()    
                       .orElse("-1");
        } catch (IOException e1) {
            return "-1";
        }
    })
    .collect(Collectors.joining(",")));