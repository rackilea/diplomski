try{
        account.someFunction();
    }catch(OptimisticLockException o1){
        logger.log(Level.DEBUG, "org.eclipse.persistence.exceptions.OptimisticLockException thrown !");         
    }catch(javax.persistence.OptimisticLockException o2){
        logger.log(Level.DEBUG, "javax.persistence.OptimisticLockException thorwn !");          
    }catch(Exception e){            

        int i=1;

        for(Throwable t=(Throwable)e; t!=null; t=t.getCause()){
            if(t instanceof OptimisticLockException)
                logger.log(Level.DEBUG, "org.eclipse.persistence.exceptions.OptimisticLockException thrown by Exception block ! " + i);
            else if(t instanceof javax.persistence.OptimisticLockException)
                logger.log(Level.DEBUG, "javax.persistence.OptimisticLockException thrown by Exception block ! " + i);
            else
                logger.log(Level.DEBUG, t + " " + i);
            i++;
        }

    }