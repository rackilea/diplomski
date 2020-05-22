If your input is "Alpha + Beta" , then the below code results in 
Alpha
+
Beta



StringTokenizer var = new StringTokenizer("Alpha + Beta"," ");
            while (var.hasMoreElements())
            {
                System.out.println(var.nextToken());
            }