// Step 0: Initialize input and output

input <- [carbohydrate, cart, carburetor, caramel, caribou, carbonic, cartilage, carbon, carriage, carton, car, carbonate]
output <- [ , , , , , , , , , , , ]

allFound <- false; // Helper variable to know if all prefixes are valid

while (not allFound) { // Step 2 Iteration: until all prefixes are ok

    // For simplicity, we first count the occurrences of each prefix
    for each prefix in output {
        prefixCount[prefix] <- prefixCount[prefix] + 1 // You may use a Map for this 
    }

    // Step 1: For each prefix check if is valid, if not add one more char
    allFound <- true; 
    for (i = 0; i < output size; i++) {
        if not (prefixCount[prefix] == 1 /* is unique */ OR output[i] is equals input[i]) {
            // Prefix is not ok                
            output[i] <- output[i] + next char form input[i]; // Add one more char
            allFound <- false; // Step 2 iteration condition "some prefix is not valid"
        }       
    }   
}