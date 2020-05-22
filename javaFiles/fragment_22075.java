System.out.println("Enter your text(Type 'exit' to close program.): ");
            bw = new BufferedWriter(new FileWriter(quotesFile, true));
            input = kb.nextLine();
            if(!input.equalsIgnoreCase("exit")) {
                bw.write(input);
                bw.newLine();
                bw.close();
                System.out.println("Entry added.\n");
            }
       }