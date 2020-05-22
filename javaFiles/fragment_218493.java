List<Integer> path = new ArrayList();
int pos = LocationOfChosenUser;

while(pos != sourceVertex) {
   path.add(pos);
   pos = comeFrom[pos];
}

for (int i=path.size()-1; i>=0; i--) {
   System.out.print(path.get(i));
   if (i > 0) System.out.print(" -> ");
}