while (reader.hasNextLine()) {
    // during the last iteration, this next call consumes the final line
    String line = reader.nextLine();

    if (word.isEmpty()) {
        // but then you call nextLine() here again, causing the exception
        //System.out.println(reader.nextLine());
        System.out.println(line);
    }
}