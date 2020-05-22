if (tokens.length >= 3) {
    prereqcl.add(new prereqclass(tokens[0].trim(),tokens[1].trim(),tokens[2].trim() ) );
}
else {
    System.out.println("Only found " + tokens.length + " tokens.");
}