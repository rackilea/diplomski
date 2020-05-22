from("file://inputdir/")
    .choice()
        .when(bodyAs(String.class).contains("error"))
            .to(/* a route for errors */)
        .otherwise()
            .to(/* a route for non-errors */);