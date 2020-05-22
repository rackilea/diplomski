Runtime runtime = Runtime.getRuntime() ;
            Process process = runtime.exec("Your command") ;
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream())) ;
            String line = null ;
            while ((line = reader.readLine())!= null){
                System.out.println(line);
            }