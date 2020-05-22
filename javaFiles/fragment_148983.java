try {
        c.eval("print(ggplot(df, aes(x=Date, y=UID)) + geom_point(shape=1))"); // point graph
        System.out.print("Success");
    } catch (Exception e) {
        out.print(e.getMessage()); 
        System.out.print("Failed");
    }