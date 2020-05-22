void push(char x) 
    {
        if (top == 99)
            System.out.println("Stack full");
        else {
            top = top + 1;
            items[top] = x;
        }

    }