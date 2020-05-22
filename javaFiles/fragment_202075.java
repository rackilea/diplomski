Scanner fromUser = new Scanner(System.in);
try (DataOutputStream dos = new DataOutputStream(s1.getOutputStream())) {
        System.out.println("Enter the item id that you want:\n");
        id = fromUser.nextInt();
        dos.writeInt(id);
        System.out.println("Enter the amount of item that you want:\n");
        amt = fromUser.nextInt();
        dos.writeInt(amt);
        dos.flush();
    }