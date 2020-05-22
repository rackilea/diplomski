TreeSet ageRank = new TreeSet();
TreeSet incomeRank = new TreeSet();

for(Person p : persons){
   ageRank.add(p.getAge());
   incomeRank.add(p.getIncome());
}

Collections.sort(persons, new Comparator<Person>(){
        @Override
        public int compare(Person p1, Person p2) {              
             int ageRank1 = ageRank.tailSet(p1.getAge()).size();
             int ageRank2 = ageRank.tailSet(p2.getAge()).size();
             int incomeRank1 = incomeRank.tailSet(p1.getIncome()).size();
             int incomeRank2 = incomeRank.tailSet(p2.getIncome()).size();
             //Calculate the combined_rank and return result here. Code omitted  

        }
});