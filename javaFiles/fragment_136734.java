System.out.println("Your list for today is: " + "\n");
for (int page = 0; page <= (to_do.size() / 4); page++) {
    for (int offset = 0; offset + page * 4 < to_do.size() && offset < 4; offset++) {
            System.out.println(to_do.get(page * 4 + offset));
        }
        user_input.nextLine();
    }
}