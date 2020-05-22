List<Comparator<Task>> comparators = new ArrayList<Comparator<Task>>();
//first sort on time    
comparators.add(new TimeComparator());
//then on priority
comparators.add(new HighPriorityComparator());
MixAndMatchComparator orComparator = new MixAndMatchComparator(comparators);
PriorityQueue<Task> queue = new PriorityQueue<Task>(3, orComparator);