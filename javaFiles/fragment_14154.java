try{
        throw new RuntimeException();
    }
    catch (Exception e){
        System.out.println(Arrays.hashCode(e.getStackTrace()));
        System.out.println(Arrays.hashCode(e.getStackTrace()));
        System.out.println(Arrays.hashCode(e.getStackTrace()));
    }