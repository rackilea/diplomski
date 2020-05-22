boolean flag = false;
int count = 0;
do {
    System.out.println("Please enter one name: ");
    name = input.nextLine();
    if (name.equalsIgnoreCase("stop")) flag = true;
    if (!flag) {
        count++;
        qName.enqueue(name);
    }
    if (count > 3) {
        count--;
        System.out.println(qName.dequeue());
    }
} while (!flag);
for (int x = 0; x < 3; x++) System.out.println(qName.dequeue());