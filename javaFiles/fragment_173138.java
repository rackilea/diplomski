for (int i=0; i<class_number; i=i+1) {
    name[i] = Console.getString("Enter Name");
    score[i] = Console.getInt("Enter score");
}
for (int i=0; i < class_number; i++) {
    if (score[i] < average(score))
        System.out.print(name[i] + " ");
}