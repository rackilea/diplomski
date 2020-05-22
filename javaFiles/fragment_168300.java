while (number >= 0 && size < values.length) {
        values[size] = number; //Line added
        size++;
        sum += number;
        System.out.print("Enter a positive number, negative number will end entry.");
        number = input.nextDouble();
    }

    sum = sum + number;
    average = sum / size;
    System.out.println("The average of the numbers as of right now is " + average);

}

public void printList(){
    System.out.print("[");
    for (int i = 0; i <= size; i++){
        System.out.print(values[i]+", ");
    }
    System.out.println("end]");
}

public static void main(String[] args) {
    MyContainer cont = new MyContainer();
    cont.run();
    cont.printList();
}