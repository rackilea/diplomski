// A method that expects a collection:
void process(List<String> strings) { ... }

void call()
{
    String array[] = new String[] { "A", "B", "C" };

    // Pass the array (as a list) to the method:
    process(Arrays.asList(array));
}