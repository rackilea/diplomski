Process process = pb.start();
        OutputHandler out
                = new OutputHandler(process.getInputStream(), "UTF-8");
        OutputHandler err
                = new OutputHandler(process.getErrorStream(), "UTF-8");
        int status = process.waitFor();
        System.out.println("Status: " + status);
        out.join();
        System.out.println("Output:");
        System.out.println(out.getText());
        System.out.println();
        err.join();
        System.out.println("Error:");
        System.out.println(err.getText());