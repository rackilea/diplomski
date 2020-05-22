int columnToSort = 2; // between 0 and 3; because it's array index
Collections.sort(l, (o1, o2) -> {
        String[] line1 = o1.split("\\|");
        String[] line2 = o2.split("\\|");
        if(line1.length !=4 || line2.length !=4)
            throw new IllegalArgumentException("One line has not the expected size");
        if(line1[columnToSort].matches("\\d+))
            return Integer.compare(Integer.parseInt(line1[columnToSort]), 
                               Integer.parseInt(line2[columnToSort]));
        else
            return line1[columnToSort].compareTo(line2[columnToSort]);
});