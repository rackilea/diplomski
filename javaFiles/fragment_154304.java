for(Base currentBase : Start.bases)
        {
            if(currentBase.getId() == id && !currentBase.ifEmpty())
            {
                String output = currentBase.getMessage();
                os.println(output);
                System.out.println(output +" *FOT* "+ addr.getHostName());
            }
        }