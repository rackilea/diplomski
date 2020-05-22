while(scanner.hasNext()) {
            String s = scanner.nextLine();
            outputStream.print(s+"\n");
            System.out.println("Test "+s); //d.h. das Problem liegt am outputstream
        }
        outputStream.close();
        scanner.close();