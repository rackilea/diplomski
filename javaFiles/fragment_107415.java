while ((strLine = br.readLine()) != null)   
        {
            ++i;
            if(startline == 0) // set startline only if startline is zero, which will happen the first time and everytime you've printed the status
                startline = i;
            int line = Integer.parseInt(strLine);
            sum=sum+line;
            System.out.println("Sum= "+sum);
            if(sum>=param2)
            {                 
                /* System.out.println("line number : "+i);*/ 
                System.out.println("Start line number :"+startline+" End line number:" +i);
                sum =0;
                startline = 0;  // reset startline here
            }                                
        }