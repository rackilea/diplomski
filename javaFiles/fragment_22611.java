while(!status){
    try{

        a=input.nextInt();
        b=input.nextInt();

        result=a/b;
        status=true;

    }catch (ArithmeticException ex){

        System.out.println(ex.getMessage());

    }catch(InputMismatchException ex){

        System.out.println(ex);
        input.next(); // So when ever InputMismatchException occurs Scanner will not consume the token it will keep that token so we need to consume that by using `next()`
    }catch(Exception ex){

        System.out.println(ex.getMessage());

    }