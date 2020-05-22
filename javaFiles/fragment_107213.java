for(int i = 1; i <= 21; i++) { 
        if (scanner.hasNextInt()
          subAssignment = scanner.nextInt();
        else
          throw new RuntimeException("Unexpected token, wanted a number, but got: " + scanner.next());
        assignment += subAssignment;
    }