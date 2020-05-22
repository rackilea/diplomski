VaadinSession               // Wraps a standard Servlet session.
.getCurrent()               // Access the current user’s session.
.getSession()               // Access the wrapped standard Servlet session.
.setMaxInactiveInterval(    // Set the timeout.
    ( int )                 // Cast a `long` to an `int`.
    TimeUnit                // The `TimeUnit` enum is more self-documenting than using a literal integer number.
    .MINUTES                // Here we set a half hour, 30 minutes.
    .toSeconds( 30 )        // Set a number of whole seconds.      
)
;