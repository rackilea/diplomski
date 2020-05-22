private static HashSet<String> readPuzzleFile(int wordLength) {
        HashSet<String> unProcessedPuzzle = new HashSet<String>();
        try (Scanner file = new Scanner(new File(PATHTOPUZZLE))) {
            while (file.hasNextLine()) {
                unProcessedPuzzle.add(file.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No Puzzle File Found!");
            return null;
        }
        HashSet<String> puzzle = new HashSet<String>();
        Iterator iterator = unProcessedPuzzle.iterator();
        for (String word : unProcessedPuzzle){
            puzzle.add(word); //........addAll -> add.........
        }
        return puzzle;//........return puzzle.........
       }