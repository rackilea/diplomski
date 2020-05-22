// Open the file...
boolean found = false;
while(sc.hasNextLine())
{
    // Read the line...
    if (Objects.equals(tokens[0], username) && Objects.equals(tokens[1], password) && checked)
    {
        // Do stuff...
        found = true;
        break; // Done looking
    }
}
if (!found)
{
    System.out.println("Wrong username or password .. try again !!");
}
// Close the file...