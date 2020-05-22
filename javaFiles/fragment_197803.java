while (thePlayer.position.x > thePlayer.position2.x - 60) { 
    println("x2 =" + thePlayer.position2.x);
    thePlayer.position.x = thePlayer.position.x - 1;
    println("x =" + thePlayer.position.x);
}
thePlayer.position2.x = thePlayer.position.x;
println("complete");