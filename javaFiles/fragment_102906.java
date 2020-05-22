// either this
when(employeeEndPoint.submit(employee)).thenReturn(
   new Response("ERROR"),
   new Response("ERROR"),
   new Response("SUCCESS") // returned at 3rd call and all following
);
// or that
when(employeeEndPoint.submit(employee))
    .thenReturn(new Response("ERROR"))
    .thenReturn(new Response("ERROR"))
    .thenReturn(new Response("SUCCESS"));// returned at 3rd call and all following