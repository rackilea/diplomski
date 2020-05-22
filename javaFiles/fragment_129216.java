String command ="cmd.exe /C "+ "javac C:\\student\\workspace\\javaproject\\Testing\\src\\TestCalculator.java"; 
        Process p = Runtime.getRuntime().exec(command);
        InputStream i = p.getErrorStream();
        int c;
        while((c=i.read())!=-1)
            System.out.print((char)c);