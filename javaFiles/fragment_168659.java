Scanner input1 = new Scanner(new File(firstName));//read first file
Scanner input2 = new Scanner(new File(secondName));//read second file

while(input1.hasNextLine() && input2.hasNextLine()){
    first = input1.nextLine();   
    second = input2.nextLine(); 

    if(!first.equals(second)){
        System.out.println("Differences found: "+"\n"+first+'\n'+second);
    }
}

// optionally handle any remaining lines if the line count differs