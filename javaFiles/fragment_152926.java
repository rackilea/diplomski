for(double i=-10;i<=10;){
        try{
            c1 = new CompositeFunction(si,l);
            System.out.print(c1+" = ");
            double value = c1.eval(i);
            value = value + s.eval(i);
            System.out.println("f(x) = "+value);
            i = i+0.5;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }