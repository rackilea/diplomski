List<Athlete> athletes = parseAthletes("athlete.txt");
Comparator<Athlete> athletesById = new Comparator<Athlete>() {
    @Override
    public int compare(Athlete a,Athlete b) {
        return Integer.compare(a.getId(),b.getId());
    }
}
Collections.sort(athletes,athletesById);
for(Athlete athlete : athletes) {
    System.out.println(athlete.toString());
}