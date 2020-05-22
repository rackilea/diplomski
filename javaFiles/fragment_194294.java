// Create String ArrayList
ArrayList<String> strings = new ArrayList<>();
strings.add("a"); strings.add("b"); strings.add("c");

// Convert ArrayList to a simple string
String stringToPermutate = String.join("", strings);

// Hold the number of elements within the strings ArrayList
int n = strings.size();

// Counter for while loop condition which will
// ultimately determine the Permutation Character
// Length for each iteration within the WHILE loop.
int k = 1;

// Prepare to build a result string that will hold
// the result from each call to the getPermutations
// method (which by the way is a recursive method).
StringBuilder sol = new StringBuilder();

while (k <= n) {
    // Call method to permutate our simple string based
    // on the Permutation Character Length stipulated by k
    ArrayList<String> permutations = getPermutations(stringToPermutate, k, true);

    // Convert ArrayList to a comma (, ) delimited string
    String listToString = String.join(", ", permutations); 

    // Ternary used here instead of IF/ELSE
    sol.append(sol.toString().equals("") ? listToString : ", " + listToString);

    // Increment counter
    k++;
}

// Split the contents of sol into a string Array
String[] solution = sol.toString().split(", ");

// Print solution String Array to Console window.
System.out.println(Arrays.toString(solution));