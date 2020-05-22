System.out.println("Enter a name");
name = in.readLine();

System.out.println("Enter a id guideline");
input = in.readLine();
index = input.indexOf("-");

try {
    String currentIDValue = input;
    String replaceIDValue = null;
    id = 0;
    if (index >= 0) {
        currentIDValue = input.substring(0, input.lastIndexOf("-"));
        replaceIDValue = input.substring(input.lastIndexOf("-") + 1);

        id = Integer.parseInt(currentIDValue);
    } else {
        id = Integer.parseInt(currentIDValue);
    }

    Store s = new Store(name, id);
    if (stores.contains(s)) {

        index = stores.indexOf(s);
        s = stores.get(index);

        System.out.println("You have selected " + s);
        if (replaceIDValue != null) {

            newId = Integer.parseInt(replaceIDValue);
            // update the ID

        }

    } else {

        System.out.println("Item does not exist");
    }
} catch (NumberFormatException exp) {
    exp.printStackTrace();
}