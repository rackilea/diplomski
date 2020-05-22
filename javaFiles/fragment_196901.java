while ((line = br.readLine()) != null) { 
    if(line.contains(".")) {
        String[] parts = line.split("\\."); 
        String part1 = parts[0]; 
        String part2 = parts[1];
    } else {
        System.out.println("Corrupted data as: " + line);
    }
}