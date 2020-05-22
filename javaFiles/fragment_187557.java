List<DMatch> matchesList = matches.toList();
Double max_dist = 0.0;
Double min_dist = 100.0;

for (int i = 0; i < matchesList.size(); i++) {
    Double dist = (double) matchesList.get(i).distance;
    if (dist < min_dist)
        min_dist = dist;
    if (dist > max_dist)
    max_dist = dist;
}

LinkedList<DMatch> good_matches = new LinkedList<DMatch>();
for (int i = 0; i < matchesList.size(); i++)  {  
    if (matchesList.get(i).distance <= (3 * min_dist)) // change the limit as you desire
    good_matches.addLast(matchesList.get(i));
}