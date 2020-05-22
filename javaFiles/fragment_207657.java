public int calculateFloors(int current, Set<Integer> visited) {
    int floors = 0;

    // get the values of the directions (add your code here to get them)
    int north = Integer.parseInt(scanner.nextLine()); 
    int east = Integer.parseInt(scanner.nextLine()); 
    int west = Integer.parseInt(scanner.nextLine()); 
    int south = Integer.parseInt(scanner.nextLine()); 
    int down = Integer.parseInt(scanner.nextLine()); 
    int up = Integer.parseInt(scanner.nextLine()); 


    if (up > 0 && !visited.contains(up)) {
        visited.add(up);
        floors = calculateFloors(up, visited) + 1;
    }

    if (down > 0 && !visited.contains(down)) {
        visited.add(down);
        int result = calculateFloors(down, visited) - 1;
        floors = result > floors ? result : floors;
    }

    if (north > 0 && !visited.contains(north)) {
        visited.add(north);
        int result = calculateFloors(norht, visited);
        floors = result > floors ? result : floors;
    }

    if (south > 0 && !visited.contains(south)) {
        visited.add(south);
        int result = calculateFloors(south, visited);
        floors = result > floors ? result : floors;
    }
    if (west > 0 && !visited.contains(west)) {
        visited.add(west);
        int result = calculateFloors(west, visited);
        floors = result > floors ? result : floors;
    }
    if (east > 0 && !visited.contains(east)) {
        visited.add(east);
        int result = calculateFloors(east, visited);
        floors = result > floors ? result : floors;
    }


    return floors;
}