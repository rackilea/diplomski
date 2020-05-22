double alphaTotal = 0;
double betaTotal = 0;
double gammaTotal = 0;

input.nextLine();
while (input.hasNextLine()) {
     String line = input.nextLine();
     String[] tokens = line.split("\\s+");
     double raised = Double.parseDouble(tokens[1].trim());

     if ("Alpha".equals(tokens[2])){
         alphaTotal += raised;
     } esle if ("Beta".equals(tokens[2])) {
         betaTotal += raised;
     } else if ("Gamma".equals(tokens[2])) {
         gammaTotal += raised;
     }
}

// Print out the winner
if (alphaTotal > betaTotal && alphaTotal > gammaTotal){
    System.out.println("Team Aplha wins with $" + alphaTotal);
} else if ( .... .... .... ){
    ....
} else if ( .... .... .... ){
    ....
}