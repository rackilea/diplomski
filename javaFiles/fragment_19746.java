int quit_position = input.indexOf("quit");
if (quit_position >= 0) {
    System.out.println(input.substring(0, quit_position));
} else {
    System.out.println(input);
}