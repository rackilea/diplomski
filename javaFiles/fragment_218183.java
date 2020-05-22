for (int x = 0; x < total; x++) {
    System.out.println("Enter the type of animal " + x + 1);
    animals[x].type = input.next();
}

for (int x1 = 0; x1 < total; x1++) {
    System.out.println("Enter the weight of the animal " + (x1 + 1));
    animals[x1].weight = Integer.parseInt(input.next());
}