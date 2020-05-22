Pattern commandPattern = Pattern.compile("(traverse|search|delete|insert) *(\\d*)");
Matcher matcher = commandPattern.match(in.nextLine());
if (!matcher.matches()) {
    System.out.println("Illegal command. Try again.");
    matcher = commandPattern.match(in.nextLine());
}
switch (matcher.group(1).toLowerCase()) {
    case "traverse":
        bst.traverse(root);
        break;
    case "delete":
        int deleteKey = Integer.parseInt(matcher.group(2));
        if (bst.delete(deleteKey)) {
            ...