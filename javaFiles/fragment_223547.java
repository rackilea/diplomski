List<Comparator<Task>> comparators = new ArrayList<Comparator<Task>>();
//first sort on priority            
comparators.add(new HighPriorityComparator());
//then on time
comparators.add(new TimeComparator());
MixAndMatchComparator orComparator = new MixAndMatchComparator(comparators);
PriorityQueue<Task> queue = new PriorityQueue<Task>(3, orComparator);