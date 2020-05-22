plotAreaCorridor <- function(x, y, col.poly1="lightgray", col.poly2="gray",...) {
    x.pol <- c(x, rev(x), x[1])
    y.pol <- c(y[,1], rev(y[,5]),y[,1][1])
    plot(x, y[,6]+1, type="n", ...) 
    polygon(x.pol, y.pol, col=col.poly1, lty=0)

    x.pol <- c(x, rev(x), x[1])
    y.pol <- c(y[,2], rev(y[,4]), y[,1][1])
    polygon(x.pol, y.pol, col=col.poly2, lty=0)

    lines(x, y[,3], col="blue") # median
    lines(x, y[,6], col="red")  # max

    invisible(NULL)
}