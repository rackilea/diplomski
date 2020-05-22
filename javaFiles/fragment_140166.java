boolean flag = false;
do {
    System.out.println("Please enter one name: ");
    name = input.nextLine();
    if(name.equalsIgnoreCase("stop")) flag = true;
    if (!flag) qName.enqueue(name);
    if (qName.getCount() > 3) System.out.println(qName.dequeue());
} while (!flag);
for (int x = 0; x < 3; x++) System.out.println(qName.dequeue());