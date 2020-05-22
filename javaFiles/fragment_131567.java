public void hostFlea(Flea flea) {
    if(fleas.size() >= 5) {
        System.out.println("This dog has too many fleas!");
    } else {
        fleas.add(flea);
    }
}