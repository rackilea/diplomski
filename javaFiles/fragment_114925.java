for (Object response : Arrays.asList(new ProceedConditionally("asdf"), Reject$.MODULE$)) {
        if(Reject$.class.isInstance(response)){
            Reject$ cast = Reject$.class.cast(response);
            System.out.println(cast);
        }else if(Proceed.class.isInstance(response)){
            System.out.println("Proceed");
        }else{
            System.out.println("Nothing: "+response.getClass());
        }
    }