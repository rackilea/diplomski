class PracticeComparator implements Comparator<Practice> {
           @Override
           public int compare(Practice p1, Practice p2) {

                return p1.getPracticeName().compareTo(p2.getPracticeName());
           }
}