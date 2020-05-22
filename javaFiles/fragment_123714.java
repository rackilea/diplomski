tempVec = (Vector) objin.readObject(); 
      objin.close();
      System.out.println("Read File --> Success.");

    }catch(Exception e){

      System.out.println("Read File --> Fail.");
      e.printStackTrace();

    }