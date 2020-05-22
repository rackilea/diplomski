Comparator<Age> ageComparator = new Comparator<Age>() {
    @Override
    public int compare(Age age1, Age age2) {
        if(age1.getYear() != age2.getYear()) {
            return age1.getYear() < age2.getYear() ? -1 : 1;
        } else if(age1.getMonth() != age2.getMonth()) {
            return age1.getMonth() < age2.getMonth() ? -1 : 1;
        } else if(age1.getDay() != age2.getDay()) {
            return age1.getDay() < age2.getDay() ? -1 : 1;
        } else {
            return 0;
        }
    }
}